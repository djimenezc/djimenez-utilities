package com.djimenez.util.configuration.date;

import java.io.IOException;

import com.djimenez.util.configuration.AbstractConfigurationFileHelper;
import com.djimenez.util.constants.PathConfigurationFiles;

/**
 * @author djimenez
 */
public final class DateConfigurationFileHelper extends
  AbstractConfigurationFileHelper {

  private static DateConfigurationFileHelper instance;

  public static DateConfigurationFileHelper getInstance() throws IOException {

    if (instance == null) {
      instance = new DateConfigurationFileHelper();
    }

    return instance;
  }

  private DateConfigurationFileHelper() throws IOException {

    loadBundle(PathConfigurationFiles.DATE_CONFIGURATION_FILE_PATH);
  }
}
