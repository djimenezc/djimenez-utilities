package com.djimenez.util.configuration.main;

import java.io.IOException;

import com.djimenez.util.configuration.AbstractConfigurationFileHelper;
import com.djimenez.util.constants.PathPropertiesFiles;

/**
 * @author djimenez
 */
public final class MainConfigurationFileHelper extends
  AbstractConfigurationFileHelper {

  private static MainConfigurationFileHelper instance;

  public static MainConfigurationFileHelper getInstance() throws IOException {

    if (instance == null) {
      instance = new MainConfigurationFileHelper();
    }

    return instance;
  }

  private MainConfigurationFileHelper() throws IOException {

    loadBundle(PathPropertiesFiles.DEFAULT_PROPERTIES_FILE_PATH);
  }
}
