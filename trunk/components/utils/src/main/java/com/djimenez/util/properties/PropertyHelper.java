package com.djimenez.util.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.djimenez.util.helper.NumberHelper;

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
public class PropertyHelper {

  private static PropertyHelper instance;

  private static final Logger logger = Logger.getLogger(PropertyHelper.class);

  public static PropertyHelper getInstance() {

    if (instance == null) {

      instance = new PropertyHelper();
    }

    return instance;
  }

  private PropertyHelper() {

  }

  public Enumeration<Object> getKeys(final String filePath) {

    return getProperties(filePath).elements();
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
   * @param filePath
   *          file name or baseName
   * @return Properties map that contains key value pairs
   * @exception PropertyException
   *              if an I/O error occurs.
   */
  public Properties getProperties(final String filePath)
    throws PropertyException {

    final Properties properties = new Properties();

    try {

      final InputStream inputSteam =
        PropertyHelper.class.getClassLoader().getResourceAsStream(filePath);

      properties.load(inputSteam);

      logger.debug("Found properties file " + filePath);

    }
    catch (final FileNotFoundException e) {
      throw new PropertyException("Properties file not found " + filePath);
    }
    catch (final IOException e) {
      e.printStackTrace();
    }

    return properties;
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
  public String getProperty(final String key, final String fileName)
    throws PropertyException {

    return getProperties(fileName).getProperty(key);
  }

  /**
   * Returns the value long given a key and file name
   * 
   * @param find
   *          key in the file fileName
   * @return the value type Integer
   * @exception PropertyException
   *              if an I/O error occurs.
   */
  public Integer getPropertyInteger(final String key, final String fileName)
    throws PropertyException {

    final String value = getProperties(fileName).getProperty(key);

    Integer intProperty = null;

    if (NumberHelper.validateNumberInt(value)) {

      intProperty = Integer.valueOf(value);
    }
    return intProperty;
  }

  /**
   * Returns the value long given a key and file name
   * 
   * @param find
   *          key in the file fileName
   * @return the value type Long
   * @exception PropertyException
   *              if an I/O error occurs.
   */
  public Long getPropertyLong(final String key, final String fileName)
    throws PropertyException {

    final String value = getProperties(fileName).getProperty(key);

    Long longProperty = null;

    if (NumberHelper.validateNumberLong(value)) {
      longProperty = Long.valueOf(value);
    }

    return longProperty;
  }

}
