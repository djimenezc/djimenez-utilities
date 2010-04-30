package com.djimenez.example.spring.mvc.constants;

/**
 * Constant values used throughout the application.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class Constants {

  /**
   * The name of the ResourceBundle used in this application
   */
  public static final String BUNDLE_KEY = "ApplicationResources";

  /**
   * File separator from System properties
   */
  public static final String FILE_SEP = System.getProperty("file.separator");

  /**
   * The name of the User role, as specified in web.xml
   */
  public static final String USER_ROLE = "ROLE_USER";

  /**
   * The name of the user's role list, a request-scoped attribute when
   * adding/editing a user.
   */
  public static final String USER_ROLES = "userRoles";

  private Constants() {
    // hide me
  }

}
