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
  private static final Logger logger = Logger.getLogger(DCSInfoImpl.class);

  // Fichero asociado a la informacion de red de DCS
  private final String DEFAULT_FILE =
    "/usr/local/n2a/lib/i386/gcc32/dcs/dcs.ini";

  private final String SECTION_DCS = "Dcs";
  private final String KEY_ADDRESS = "Address";

  // Wrapper for INI-DOS file
  private final INIFileHelper iniFileHelper = new INIFileHelper();

  // Getters and setters
  private final String comments = null;

  public DCSInfoImpl() {
    this.iniFileHelper.setPathFile(this.DEFAULT_FILE);
  }

  public DCSInfoImpl(final String pathFile) {
    this.iniFileHelper.setPathFile(pathFile);
  }

  @Override
  public String getIP() throws NetException {

    try {

      logger.debug("Retrieve DCS ip address");

      return this.iniFileHelper.getProperty(this.SECTION_DCS, this.KEY_ADDRESS);

    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public void setIP(final String value) throws NetException {

    try {
      this.iniFileHelper.setProperty(new ValidatorIPFormat(), this.SECTION_DCS,
        this.KEY_ADDRESS, value, this.comments);

    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }
}
