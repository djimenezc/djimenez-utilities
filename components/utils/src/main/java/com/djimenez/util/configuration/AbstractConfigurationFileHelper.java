package com.djimenez.util.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.djimenez.util.configuration.exception.ConfigurationFileException;

/**
 * @author djimenez
 * @version 1.0
 */
public abstract class AbstractConfigurationFileHelper {

  private static Logger logger =
    Logger.getLogger(AbstractConfigurationFileHelper.class);

  private Properties properties;

  public final Long getLong(final String key) {
    final String value = this.properties.getProperty(key);
    return Long.valueOf(value);
  }

  public final String getProperty(final String key) {
    return this.properties.getProperty(key);
  }

  protected final void loadBundle(final String filePath) {

    this.properties = new Properties();

    try {
      final InputStream inputStream =
        AbstractConfigurationFileHelper.class.getClassLoader()
          .getResourceAsStream(filePath);
      this.properties.load(inputStream);
      logger.debug("Found properties file " + filePath);
    }
    catch (final IOException e) {
      logger.warn(e.getMessage(), e.getCause());
      throw new ConfigurationFileException(e.getMessage(), e.getCause());
    }
  }
}