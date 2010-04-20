package com.djimenez.util.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

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

  protected final void loadBundle(final String filePath) throws IOException {

    this.properties = new Properties();

    final InputStream inputStream =
      AbstractConfigurationFileHelper.class.getClassLoader()
        .getResourceAsStream(filePath);
    this.properties.load(inputStream);
    logger.debug("Found properties file " + filePath);
  }
}