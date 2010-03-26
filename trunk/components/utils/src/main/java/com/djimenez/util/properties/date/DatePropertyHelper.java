package com.djimenez.util.properties.date;

import com.djimenez.util.constants.PathPropertiesFiles;
import com.djimenez.util.properties.PropertyException;
import com.djimenez.util.properties.PropertyHelper;

public class DatePropertyHelper {

  private final PropertyHelper propertyHelper;

  private static DatePropertyHelper instance;

  public static DatePropertyHelper getInstance() {

    if (instance == null) {

      instance = new DatePropertyHelper();
    }

    return instance;
  }

  private DatePropertyHelper() {

    propertyHelper = PropertyHelper.getInstance();
  }

  /**
   * @param find
   *          key in the default file TProperties.PROPERTIES_DEFAULT
   * @return the value type Integer
   * @see es.dia.pos.n2a.AbstractPropertyHelper.configuration.ConfigurationHelperFO#getPropertyInteger(String,String)
   */
  public Integer getIntegerProperty(final String key) {

    return propertyHelper.getPropertyInteger(key,
      PathPropertiesFiles.DATE_PROPERTIES_FILE_PATH);
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
      PathPropertiesFiles.DATE_PROPERTIES_FILE_PATH);
  }

  /**
   * @param find
   *          key in the default file TProperties.PROPERTIES_DEFAULT
   * @return the value type Long
   * @see es.dia.pos.n2a.AbstractPropertyHelper.configuration.ConfigurationHelperFO#getPropertyLong(String,
   *      String)
   */
  public Long getPropertyLong(final String key) {

    return propertyHelper.getPropertyLong(key,
      PathPropertiesFiles.DATE_PROPERTIES_FILE_PATH);
  }

}
