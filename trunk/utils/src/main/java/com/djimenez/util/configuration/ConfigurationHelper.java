package com.djimenez.util.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public final class ConfigurationHelper {

  private static final Logger logger =
    Logger.getLogger(ConfigurationHelper.class);
  private static final String PROPERTIES_FILE_NAME = "n2a-config.properties";

  public static ConfigurationHelper getInstance() {
    if (instance == null) {
      instance = new ConfigurationHelper();
    }

    return instance;
  }

  private Properties properties;

  private static ConfigurationHelper instance;

  private ConfigurationHelper() {
    this.loadBundle();
  }

  public String getCmosBackupPath() {
    return (this.getProperty("resourceBase") + this
      .getProperty("cmos.backup.path"));
  }

  public Long getLong(final String key) {
    final String value = this.properties.getProperty(key);
    return Long.valueOf(value);
  }

  public String getPosMasterIp() {
    return this.getProperty("pos.master.ip");
  }

  public String getPosMasterServerUrl() {
    return this.getProperty("pos.master.server.url");
  }

  public String getProperty(final String key) {
    return this.properties.getProperty(key);
  }

  private void loadBundle() {
    this.properties = new Properties();
    try {
      final InputStream inputStream =
        ConfigurationHelper.class.getClassLoader().getResourceAsStream(
          PROPERTIES_FILE_NAME);
      this.properties.load(inputStream);
      logger.debug("Found properties file " + PROPERTIES_FILE_NAME);
    }
    catch (final IOException e) {
      logger.warn(e.getMessage(), e.getCause());
      throw new ConfigurationException(e.getMessage(), e.getCause());
    }
  }
}
