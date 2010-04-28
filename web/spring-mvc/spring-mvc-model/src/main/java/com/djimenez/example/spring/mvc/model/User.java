package com.djimenez.example.spring.mvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

import com.djimenez.example.spring.mvc.constants.JpaConstants;

/**
 * This class represents the basic "user" object in AppFuse that allows for
 * authentication and user management. It implements Acegi Security's
 * UserDetails interface.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Updated by
 *         Dan Kibler (dan@getrolling.com) Extended to implement Acegi
 *         UserDetails interface by David Carter david@carter.net
 */
@Entity
@Table(name = "app_user")
@Searchable
public class User extends BaseObject implements Serializable, UserDetails {

  private static final long serialVersionUID = 3832626162173359411L;

  private Long id;
  private String username; // required
  private String password; // required
  private String confirmPassword;
  private String passwordHint;
  private String firstName; // required
  private String lastName; // required
  private String email; // required; unique
  private String phoneNumber;
  private String website;
  private Address address = new Address();
  private Integer version;
  private Set<Role> roles = new HashSet<Role>();
  private boolean enabled;
  private boolean accountExpired;
  private boolean accountLocked;
  private boolean credentialsExpired;

  /**
   * Default constructor - creates a new instance with no values set.
   */
  public User() {
  }

  /**
   * Create a new instance and set the username.
   * 
   * @param username
   *          login name for user.
   */
  public User(final String username) {
    this.username = username;
  }

  /**
   * Adds a role for the user
   * 
   * @param role
   *          the fully instantiated role
   */
  public final void addRole(final Role role) {
    getRoles().add(role);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }

    final User user = (User) o;

    return !(username != null ? !username.equals(user.getUsername()) : user
      .getUsername() != null);

  }

  @Embedded
  @SearchableComponent
  public final Address getAddress() {
    return address;
  }

  /**
   * @return GrantedAuthority[] an array of roles.
   * @see org.springframework.security.userdetails.UserDetails#getAuthorities()
   */
  @Transient
  public final GrantedAuthority[] getAuthorities() {
    return roles.toArray(new GrantedAuthority[0]);
  }

  @Transient
  public final String getConfirmPassword() {
    return confirmPassword;
  }

  @Column(nullable = false, unique = true)
  @SearchableProperty
  public final String getEmail() {
    return email;
  }

  @Column(name = "first_name", nullable = false, length = JpaConstants.NAME_LENGTH)
  @SearchableProperty
  public final String getFirstName() {
    return firstName;
  }

  /**
   * Returns the full name.
   * 
   * @return firstName + ' ' + lastName
   */
  @Transient
  public final String getFullName() {
    return firstName + ' ' + lastName;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @SearchableId
  public final Long getId() {
    return id;
  }

  @Column(name = "last_name", nullable = false, length = JpaConstants.NAME_LENGTH)
  @SearchableProperty
  public final String getLastName() {
    return lastName;
  }

  @Column(nullable = false)
  public final String getPassword() {
    return password;
  }

  @Column(name = "password_hint")
  public final String getPasswordHint() {
    return passwordHint;
  }

  @Column(name = "phone_number")
  @SearchableProperty
  public final String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Convert user roles to LabelValue objects for convenience.
   * 
   * @return a list of LabelValue objects with role information
   */
  @Transient
  public final List<LabelValue> getRoleList() {
    final List<LabelValue> userRoles = new ArrayList<LabelValue>();

    if (this.roles != null) {
      for (final Role role : roles) {
        // convert the user's roles to LabelValue Objects
        userRoles.add(new LabelValue(role.getName(), role.getName()));
      }
    }

    return userRoles;
  }

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = @JoinColumn(name = "role_id"))
  public final Set<Role> getRoles() {
    return roles;
  }

  @Column(nullable = false, length = JpaConstants.NAME_LENGTH, unique = true)
  @SearchableProperty
  public final String getUsername() {
    return username;
  }

  @Version
  public final Integer getVersion() {
    return version;
  }

  @SearchableProperty
  public final String getWebsite() {
    return website;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final int hashCode() {
    return (username != null ? username.hashCode() : 0);
  }

  @Column(name = "account_expired", nullable = false)
  public final boolean isAccountExpired() {
    return accountExpired;
  }

  @Column(name = "account_locked", nullable = false)
  public final boolean isAccountLocked() {
    return accountLocked;
  }

  /**
   * @see org.springframework.security.userdetails.UserDetails#isAccountNonExpired()
   */
  @Transient
  public final boolean isAccountNonExpired() {
    return !isAccountExpired();
  }

  /**
   * @see org.springframework.security.userdetails.UserDetails#isAccountNonLocked()
   */
  @Transient
  public final boolean isAccountNonLocked() {
    return !isAccountLocked();
  }

  @Column(name = "credentials_expired", nullable = false)
  public final boolean isCredentialsExpired() {
    return credentialsExpired;
  }

  /**
   * @see org.springframework.security.userdetails.UserDetails#isCredentialsNonExpired()
   */
  @Transient
  public final boolean isCredentialsNonExpired() {
    return !credentialsExpired;
  }

  @Column(name = "account_enabled")
  public final boolean isEnabled() {
    return enabled;
  }

  public final void setAccountExpired(final boolean accountExpired) {
    this.accountExpired = accountExpired;
  }

  public final void setAccountLocked(final boolean accountLocked) {
    this.accountLocked = accountLocked;
  }

  public final void setAddress(final Address address) {
    this.address = address;
  }

  public final void setConfirmPassword(final String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public final void setCredentialsExpired(final boolean credentialsExpired) {
    this.credentialsExpired = credentialsExpired;
  }

  public final void setEmail(final String email) {
    this.email = email;
  }

  public final void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }

  public final void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public final void setId(final Long id) {
    this.id = id;
  }

  public final void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public final void setPassword(final String password) {
    this.password = password;
  }

  public final void setPasswordHint(final String passwordHint) {
    this.passwordHint = passwordHint;
  }

  public final void setPhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public final void setRoles(final Set<Role> roles) {
    this.roles = roles;
  }

  public final void setUsername(final String username) {
    this.username = username;
  }

  public final void setVersion(final Integer version) {
    this.version = version;
  }

  public final void setWebsite(final String website) {
    this.website = website;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final String toString() {
    final ToStringBuilder sb =
      new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("username",
        this.username).append("enabled", this.enabled).append("accountExpired",
        this.accountExpired).append("credentialsExpired",
        this.credentialsExpired).append("accountLocked", this.accountLocked);

    final GrantedAuthority[] auths = this.getAuthorities();
    if (auths != null) {
      sb.append("Granted Authorities: ");

      for (int i = 0; i < auths.length; i++) {
        if (i > 0) {
          sb.append(", ");
        }
        sb.append(auths[i].toString());
      }
    }
    else {
      sb.append("No Granted Authorities");
    }
    return sb.toString();
  }
}
