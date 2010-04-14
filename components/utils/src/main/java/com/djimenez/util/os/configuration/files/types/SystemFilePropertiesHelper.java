package com.djimenez.util.os.configuration.files.types;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.djimenez.util.net.NetException;
import com.djimenez.util.os.configuration.files.validators.Validator;

/**
 * Wrapper for system file in properties file format. Example files in Red-Hat
 * systems: $/etc/sysconfig/network $/etc/sysconfig/network-scripts/ifcfg-eth0
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public class SystemFilePropertiesHelper {

  // Logger
  // private static final Logger logger =
  // Logger.getLogger(SystemFilePropertiesHelper.class);

  // Path properties file.
  private String pathFile = null;
  // Properties JAVA Standard API
  private final Properties propertiesFile = new Properties();

  //
  // Getters and Setters
  //
  public String getPathFile() {
    return this.pathFile;
  }

  /**
   * Return the value for the key passed in system config file in properties
   * file format.
   * 
   * @param key
   *          The key.
   * @return The value of the key or null is key not exist
   * @throws IOException
   *           On loading file error.
   */
  public String getProperty(final String key) throws IOException {
    this.load();
    return (String) this.propertiesFile.get(key);
  }

  /**
   * Load the properties file
   * 
   * @throws IOException
   */
  private void load() throws IOException {

    final FileInputStream file = new FileInputStream(this.pathFile);

    this.propertiesFile.load(file);

    file.close();
  }

  public void setPathFile(final String pathFile) {
    this.pathFile = pathFile;
  }

  /**
   * Set a property in system config file in properties file format. The key is
   * added if not exits in file.
   * 
   * @param key
   *          Property
   * @param value
   *          Value of property
   * @param comment
   *          Add a comment before the generated comment with modification date.
   *          If null, no comment is added before the modification date.
   * @throws IOException
   *           On storing file error or validation error
   */
  public void setProperty(final String key, final String value,
    final String comment) throws IOException {

    this.load();
    this.propertiesFile.setProperty(key, value);
    if (comment != null) {
      this.store(comment);
    }
    else {
      this.store("");
    }
  }

  /**
   * Set a property in system config file in properties file format. The key is
   * added if not exits in file.
   * 
   * @param validator
   *          Validate the value param
   * @param key
   *          Property
   * @param value
   *          Value of property
   * @param comment
   *          Add a comment before the generated comment with modification date.
   *          If null, no comment is added before the modification date.
   * @throws IOException
   *           On storing file error or validation error
   */
  public void setProperty(final Validator<String> validator, final String key,
    final String value, final String comment) throws IOException {

    if (validator.validate(value)) {

      this.load();
      this.propertiesFile.setProperty(key, value);
      if (comment != null) {
        this.store(comment);
      }
      else {
        this.store("");
      }

    }
    else {
      throw new IOException(validator.getErrorMesg());
    }
  }

  /**
   * Store the properties file.
   * 
   * @param comments
   * @throws NetException
   */
  private void store(final String comments) throws IOException {

    final FileOutputStream file = new FileOutputStream(this.pathFile);

    this.propertiesFile.store(file, comments);

    file.close();
  }
}
