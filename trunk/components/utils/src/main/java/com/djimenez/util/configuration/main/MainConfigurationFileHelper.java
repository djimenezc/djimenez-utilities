package com.djimenez.util.configuration.main;

import com.djimenez.util.configuration.AbstractConfigurationFileHelper;
import com.djimenez.util.constants.PathPropertiesFiles;

/**
 * @author djimenez
 */
public final class MainConfigurationFileHelper extends
  AbstractConfigurationFileHelper {

  private static MainConfigurationFileHelper instance;

  public static MainConfigurationFileHelper getInstance() {

    if (instance == null) {
      instance = new MainConfigurationFileHelper();
    }

    return instance;
  }

  private MainConfigurationFileHelper() {

    loadBundle(PathPropertiesFiles.DEFAULT_PROPERTIES_FILE_PATH);
  }
}
