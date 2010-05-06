package com.djimenez.example.spring.mvc.service.user;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationTrustResolver;
import org.springframework.security.AuthenticationTrustResolverImpl;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.userdetails.UserDetails;

import com.djimenez.example.spring.mvc.constants.ConstantsRole;
import com.djimenez.example.spring.mvc.model.Role;
import com.djimenez.example.spring.mvc.model.User;

/**
 * This advice is responsible for enforcing security and only allowing
 * administrators to modify users. Users are allowed to modify themselves.
 * 
 * @author mraible
 */
public class UserSecurityAdvice implements MethodBeforeAdvice,
  AfterReturningAdvice {

  /**
   * Default "Access Denied" error message (not i18n-ized).
   */
  public static final String ACCESS_DENIED =
    "Access Denied: Only administrators are allowed to modify other users.";
  private final Log log = LogFactory.getLog(UserSecurityAdvice.class);

  /**
   * After returning, grab the user, check if they've been modified and reset
   * the SecurityContext if they have.
   * 
   * @param returnValue
   *          the user object
   * @param method
   *          the name of the method executed
   * @param args
   *          the arguments to the method
   * @param target
   *          the target class
   * @throws Throwable
   *           thrown when args[0] is null or not a User object
   */
  public final void afterReturning(final Object returnValue,
    final Method method, final Object[] args, final Object target) {
    final User user = (User) args[0];

    if (user.getVersion() != null) {
      // reset the authentication object if current user
      Authentication auth =
        SecurityContextHolder.getContext().getAuthentication();
      final AuthenticationTrustResolver resolver =
        new AuthenticationTrustResolverImpl();
      // allow new users to signup - this is OK b/c Signup doesn't allow setting
      // of roles
      final boolean signupUser = resolver.isAnonymous(auth);
      if ((auth != null) && !signupUser) {
        final User currentUser = getCurrentUser(auth);
        if (currentUser.getId().equals(user.getId())) {
          auth =
            new UsernamePasswordAuthenticationToken(user, user.getPassword(),
              user.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(auth);
        }
      }
    }
  }

  /**
   * Method to enforce security and only allow administrators to modify users.
   * Regular users are allowed to modify themselves.
   * 
   * @param method
   *          the name of the method executed
   * @param args
   *          the arguments to the method
   * @param target
   *          the target class
   * @throws Throwable
   *           thrown when args[0] is null or not a User object
   */
  public final void before(final Method method, final Object[] args,
    final Object target) {
    final SecurityContext ctx = SecurityContextHolder.getContext();

    if (ctx.getAuthentication() != null) {
      final Authentication auth = ctx.getAuthentication();
      boolean administrator = false;
      final GrantedAuthority[] roles = auth.getAuthorities();
      for (final GrantedAuthority role1 : roles) {
        if (role1.getAuthority().equals(ConstantsRole.ADMIN_ROLE)) {
          administrator = true;
          break;
        }
      }

      final User user = (User) args[0];

      final AuthenticationTrustResolver resolver =
        new AuthenticationTrustResolverImpl();
      // allow new users to signup - this is OK b/c Signup doesn't allow setting
      // of roles
      final boolean signupUser = resolver.isAnonymous(auth);

      if (!signupUser) {
        final User currentUser = getCurrentUser(auth);

        if ((user.getId() != null) && !user.getId().equals(currentUser.getId())
          && !administrator) {
          log.warn("Access Denied: '" + currentUser.getUsername()
            + "' tried to modify '" + user.getUsername() + "'!");
          throw new AccessDeniedException(ACCESS_DENIED);
        }
        else
          if ((user.getId() != null)
            && user.getId().equals(currentUser.getId()) && !administrator) {
            // get the list of roles the user is trying add
            final Set<String> userRoles = new HashSet<String>();
            if (user.getRoles() != null) {
              for (final Object o : user.getRoles()) {
                final Role role = (Role) o;
                userRoles.add(role.getName());
              }
            }

            // get the list of roles the user currently has
            final Set<String> authorizedRoles = new HashSet<String>();
            for (final GrantedAuthority role : roles) {
              authorizedRoles.add(role.getAuthority());
            }

            // if they don't match - access denied
            // regular users aren't allowed to change their roles
            if (!CollectionUtils.isEqualCollection(userRoles, authorizedRoles)) {
              log.warn("Access Denied: '" + currentUser.getUsername()
                + "' tried to change their role(s)!");
              throw new AccessDeniedException(ACCESS_DENIED);
            }
          }
      }
      else {
        if (log.isDebugEnabled()) {
          log.debug("Registering new user '" + user.getUsername() + "'");
        }
      }
    }
  }

  private User getCurrentUser(final Authentication auth) {
    User currentUser;
    if (auth.getPrincipal() instanceof UserDetails) {
      currentUser = (User) auth.getPrincipal();
    }
    else
      if (auth.getDetails() instanceof UserDetails) {
        currentUser = (User) auth.getDetails();
      }
      else {
        throw new AccessDeniedException("User not properly authenticated.");
      }
    return currentUser;
  }
}