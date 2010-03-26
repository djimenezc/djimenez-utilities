package com.djimenez.util.properties.main;

import com.djimenez.util.constants.PathPropertiesFiles;
import com.djimenez.util.properties.PropertyException;
import com.djimenez.util.properties.PropertyHelper;

public class MainPropertyHelper {

  private PropertyHelper propertyHelper;

  private static MainPropertyHelper instance;

  public static MainPropertyHelper getInstance() {
    if (instance == null) {

      instance = new MainPropertyHelper();
    }

    return instance;
  }

  private MainPropertyHelper() {
  }

  /**
   * Returns the value string given a key and file name
   * 
   * @param find
   *          key in the file fileName
   * @return the value type String
   * @exception PropertyException
   *              if an I/O error occurs.
   */
  public String getProperty(final String key) {
    return propertyHelper.getProperty(key,
      PathPropertiesFiles.DEFAULT_PROPERTIES_FILE_PATH);
  }

  /**
   * @param find
   *          key in the default file TProperties.PROPERTIES_DEFAULT
   * @return the value type Long
   * @see es.dia.pos.n2a.PropertyHelper.configuration.ConfigurationHelperFO#getPropertyLong(String,
   *      String)
   */
  public Long getLongProperty(final String key) {

    return propertyHelper.getPropertyLong(key,
      PathPropertiesFiles.DEFAULT_PROPERTIES_FILE_PATH);
  }

  /**
   * @param find
   *          key in the default file TProperties.PROPERTIES_DEFAULT
   * @return the value type Integer
   * @see es.dia.pos.n2a.PropertyHelper.configuration.ConfigurationHelperFO#getPropertyInteger(String,String)
   */
  public Integer getIntegerProperty(final String key) {

    return propertyHelper.getPropertyInteger(key,
      PathPropertiesFiles.DEFAULT_PROPERTIES_FILE_PATH);
  }
}
