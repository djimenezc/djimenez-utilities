package com.djimenez.util.os.unix;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.djimenez.util.net.DCSInfo;
import com.djimenez.util.net.NetException;
import com.djimenez.util.os.configuration.files.types.INIFileHelper;
import com.djimenez.util.os.configuration.files.validators.ValidatorIPFormat;

/**
 * Management for basic DCS configuration on a distribution based on
 * Red-Hat.(Fedora). In general: /etc/usr/local/n2a/lib/i386/gcc32/dcs/dcs.ini
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public class DCSInfoImpl implements DCSInfo {

  // Logger
  private static Logger logger = Logger.getLogger(DCSInfoImpl.class);

  // Fichero asociado a la informacion de red de DCS
  private static final String DEFAULT_FILE =
    "/usr/local/n2a/lib/i386/gcc32/dcs/dcs.ini";

  private static final String SECTION_DCS = "Dcs";
  private static final String KEY_ADDRESS = "Address";

  // Wrapper for INI-DOS file
  private final INIFileHelper iniFileHelper = new INIFileHelper();

  // Getters and setters
  private static final String COMMENTS = null;

  public DCSInfoImpl() {
    this.iniFileHelper.setPathFile(DEFAULT_FILE);
  }

  public DCSInfoImpl(final String pathFile) {
    this.iniFileHelper.setPathFile(pathFile);
  }

  @Override
  public final String getIP() throws NetException {

    try {

      logger.debug("Retrieve DCS ip address");

      return this.iniFileHelper.getProperty(SECTION_DCS, KEY_ADDRESS);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public final void setIP(final String value) throws NetException {

    try {
      this.iniFileHelper.setProperty(new ValidatorIPFormat(), SECTION_DCS,
        KEY_ADDRESS, value, COMMENTS);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }
}
