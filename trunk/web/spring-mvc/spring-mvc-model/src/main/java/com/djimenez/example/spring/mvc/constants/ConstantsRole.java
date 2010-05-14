package com.djimenez.example.spring.mvc.constants;

public final class ConstantsRole {

  /**
   * The name of the Administrator role, as specified in web.xml
   */
  public static final String ADMIN_ROLE = "ROLE_ADMIN";

  /**
   * The name of the User role, as specified in web.xml
   */
  public static final String USER_ROLE = "ROLE_USER";

  /**
   * The name of the user's role list, a request-scoped attribute when
   * adding/editing a user.
   */
  public static final String USER_ROLES = "userRoles";

  /**
   * The name of the available roles list, a request-scoped attribute when
   * adding/editing a user.
   */
  public static final String AVAILABLE_ROLES = "availableRoles";

  private ConstantsRole() {
  }
}
