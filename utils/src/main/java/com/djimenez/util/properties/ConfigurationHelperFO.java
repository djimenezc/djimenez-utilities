package com.djimenez.util.properties;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.djimenez.util.helper.NumberHelperFO;
import com.djimenez.util.helper.TPropertiesFO;
import com.djimenez.util.internationalization.InternationalizationContextHolder;

/**
 *Class that handles loading files properties and recovery of values given a
 * key or passing the key and file name. Resources can be internationalized, the
 * language and region (Locate in Java) of the meeting for this search for the
 * key.
 * 
 * @author jlp002es
 * @version 1.0
 * @see java.util.ResourceBundle
 */
public final class ConfigurationHelperFO extends ResourceBundle {

  private static final Logger logger =
    Logger.getLogger(ConfigurationHelperFO.class);
  private static ConfigurationHelperFO instance;
  private static final String RESOURCEDEFAULT = TPropertiesFO.CONFIG;

  /**
   * Method to return unique instance
   * 
   * @exception ConfigurationException
   *              if an I/O error occurs.
   */
  public static ConfigurationHelperFO getInstance() {
    if (instance == null) {
      instance = new ConfigurationHelperFO();
    }
    return instance;
  }

  /**
   * Private constructor
   * 
   * @exception ConfigurationException
   *              if an I/O error occurs.
   */
  private ConfigurationHelperFO() throws ConfigurationException {
    super();
  }

  @Override
  public Enumeration<String> getKeys() {
    return null;
  }

  /**
   * Returns the value string given a key and file name
   * 
   * @param find
   *          key in the file fileName
   * @return the value type String
   * @exception ConfigurationException
   *              if an I/O error occurs.
   */
  public String getProperty(final String key) {
    return getProperty(key, RESOURCEDEFAULT);
  }

  /**
   * Returns the value string given a key and file name
   * 
   * @param find
   *          key in the file fileName
   * @return the value type String
   * @exception ConfigurationException
   *              if an I/O error occurs.
   */
  public String getProperty(final String key, final String fileName)
    throws ConfigurationException {
    return getResourceBundle(fileName).getString(key);
  }

  /**
   * @param find
   *          key in the default file TProperties.PROPERTIES_DEFAULT
   * @return the value type Integer
   * @see es.dia.pos.n2a.utils.configuration.ConfigurationHelperFO#getPropertyInteger(String,String)
   */
  public Integer getPropertyInteger(final String key) {
    return getPropertyInteger(key, RESOURCEDEFAULT);
  }

  /**
   * Returns the value long given a key and file name
   * 
   * @param find
   *          key in the file fileName
   * @return the value type Integer
   * @exception ConfigurationException
   *              if an I/O error occurs.
   */
  public Integer getPropertyInteger(final String key, final String fileName)
    throws ConfigurationException {
    final String value = getResourceBundle(fileName).getString(key);
    Integer intProperty = null;
    if (NumberHelperFO.validateNumberInt(value)) {
      intProperty = Integer.valueOf(value);
    }
    return intProperty;
  }

  /**
   * @param find
   *          key in the default file TProperties.PROPERTIES_DEFAULT
   * @return the value type Long
   * @see es.dia.pos.n2a.utils.configuration.ConfigurationHelperFO#getPropertyLong(String,
   *      String)
   */
  public Long getPropertyLong(final String key) {
    return getPropertyLong(key, RESOURCEDEFAULT);
  }

  /**
   * Returns the value long given a key and file name
   * 
   * @param find
   *          key in the file fileName
   * @return the value type Long
   * @exception ConfigurationException
   *              if an I/O error occurs.
   */
  public Long getPropertyLong(final String key, final String fileName)
    throws ConfigurationException {
    final String value = getResourceBundle(fileName).getString(key);
    Long longProperty = null;
    if (NumberHelperFO.validateNumberLong(value)) {
      longProperty = Long.valueOf(value);
    }
    return longProperty;
  }

  /**
   * Private method to load a resourceBundle file named filename. Gets a
   * resource bundle using the specified base name(file name), sesion locale or
   * default locale. <code>getBundle</code> uses the base name, the specified
   * locale, or the default locale (obtained from {@link
   * InternationalizationContextHolder.getInstance()#getLocale()
   * Locale.getDefault}) If the specified locale's language, country, and
   * variant are all empty strings, then the base name is the only candidate
   * bundle name.
   * <ul>
   * <li>baseName + "_" + language + "_" + country
   * <li>baseName + "_" + language
   * <li>baseName
   * </ul>
   * 
   * @param fileName
   *          file name or baseName
   * @return Properties map that contains key value pairs
   * @exception ConfigurationException
   *              if an I/O error occurs.
   */
  public ResourceBundle getResourceBundle(final String fileName)
    throws ConfigurationException {
    ResourceBundle resourceBundle = null;
    try {
      resourceBundle =
        ResourceBundle.getBundle(fileName, InternationalizationContextHolder
          .getInstance().getLocale());
      if (resourceBundle == null) {
        throw new ConfigurationException("Properties file not found "
          + fileName);
      }
      logger.debug("Found properties file " + fileName);
    }
    catch (final NullPointerException e) {
      logger.warn(e.getMessage(), e.getCause());
      throw new ConfigurationException(e.getMessage());
    }
    return resourceBundle;
  }

  @Override
  protected Object handleGetObject(final String key) {
    return null;
  }

}
