package com.djimenez.pattern.core.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * The class managing Message configuration. This class uses
 * <i>n2a-messaging-config.properties</i>.
 * 
 * @author djimenez
 * @version 1.0
 */
public final class ConfigurationMessaging {

  private static final double ONE_SECOND = 1000.0;
  private static final Logger logger =
    Logger.getLogger(ConfigurationMessaging.class);
  private static final String PROPERTIES_FILE_NAME =
    "n2a-messaging-config.properties";

  private Properties properties;
  private static ConfigurationMessaging instance;

  private ConfigurationMessaging() {
    this.loadBundle();
  }

  private void loadBundle() {
    this.properties = new Properties();
    try {
      final InputStream inputStream =
        ConfigurationMessaging.class.getClassLoader().getResourceAsStream(
          PROPERTIES_FILE_NAME);
      this.properties.load(inputStream);
      if (logger.isDebugEnabled()) {
        logger.debug("Found properties file " + PROPERTIES_FILE_NAME);
      }
    }
    catch (final IOException e) {
      logger.warn(e.getMessage(), e.getCause());
      throw new ConfigurationMessagingException(e.getMessage(), e.getCause());
    }
  }

  public static ConfigurationMessaging getInstance() {
    if (instance == null) {
      instance = new ConfigurationMessaging();
    }

    return instance;
  }

  @Deprecated
  public String getMessagingServerIp() {
    return this.getProperty("messaging.server.ip");
  }

  @Deprecated
  public Long getAsyncMessagingServerPort() {
    return this.getLong("async.messaging.server.port");
  }

  @Deprecated
  public Long getMessagingServerPort() {
    return this.getLong("messaging.server.port");
  }

  @Deprecated
  public Long getConnectionTimeout() {
    return this.getLong("connection.timeout");
  }

  @Deprecated
  public Long getConnectionIdleTimeout() {
    return this.getLong("connection.idle.timeout");
  }

  @Deprecated
  public Long getConnectionWait() {
    return this.getLong("connection.wait");
  }

  public String getServerActivatorUrl() {
    return this.getProperty("messaging.server.activator.url");
  }

  public int getConnectionRetries() {
    return this.getLong("connection.retries").intValue();
  }

  private String getProperty(final String key) {
    return this.properties.getProperty(key);
  }

  private Long getLong(final String key) {
    final String value = this.getProperty(key);
    return Long.valueOf(value);
  }
}
