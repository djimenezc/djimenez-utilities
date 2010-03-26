package com.djimenez.util.configuration.date;

import com.djimenez.util.configuration.AbstractConfigurationFileHelper;
import com.djimenez.util.constants.PathConfigurationFiles;

/**
 * @author djimenez
 */
public class DateConfigurationFileHelper extends
  AbstractConfigurationFileHelper {

  private static DateConfigurationFileHelper instance;

  public static DateConfigurationFileHelper getInstance() {

    if (instance == null) {
      instance = new DateConfigurationFileHelper();
    }

    return instance;
  }

  private DateConfigurationFileHelper() {

    loadBundle(PathConfigurationFiles.DATE_CONFIGURATION_FILE_PATH);
  }
}
