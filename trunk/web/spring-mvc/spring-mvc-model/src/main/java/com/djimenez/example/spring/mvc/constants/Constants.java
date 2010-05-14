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
   * Session scope attribute that holds the locale set by the user. By setting
   * this key to the same one that Struts uses, we get synchronization in Struts
   * w/o having to do extra work or have two session-level variables.
   */
  public static final String PREFERRED_LOCALE_KEY =
    "org.apache.struts2.action.LOCALE";

  /**
   * The name of the configuration hashmap stored in application scope.
   */
  public static final String CONFIG = "appConfig";

  /**
   * The name of the CSS Theme setting.
   */
  public static final String CSS_THEME = "csstheme";

  private Constants() {
    // hide me
  }

}
