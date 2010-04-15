package com.djimenez.util.os.unix;

import java.io.IOException;

import com.djimenez.util.net.NetException;
import com.djimenez.util.net.NetInfo;
import com.djimenez.util.os.configuration.files.types.SystemFilePropertiesHelper;
import com.djimenez.util.os.configuration.files.validators.ValidatorIPFormat;

/**
 * Management for basic net info on a distribution based on Red-Hat.(Fedora) In
 * general: /etc/sysconfig/network
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public class NetInfoImpl implements NetInfo {

  // Logger
  // private static final Logger logger = Logger.getLogger(NetInfoImpl.class);

  // Fichero asociado a la informacion de red
  private static final String DEFAULT_FILE = "/etc/sysconfig/network";

  private static final String HOSTNAME = "HOSTNAME";
  private static final String GATEWAY = "GATEWAY";

  // Wrapper for properties file
  private final SystemFilePropertiesHelper systemFilePropertiesHelper;

  // Getters and setters
  private final String comments = null;

  public NetInfoImpl() {

    systemFilePropertiesHelper = new SystemFilePropertiesHelper();

    this.systemFilePropertiesHelper.setPathFile(DEFAULT_FILE);
  }

  public NetInfoImpl(final String pathFile) {

    systemFilePropertiesHelper = new SystemFilePropertiesHelper();
    this.systemFilePropertiesHelper.setPathFile(pathFile);
  }

  @Override
  public final String getGateWay() throws NetException {

    try {
      return this.systemFilePropertiesHelper.getProperty(GATEWAY);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public final String getHostName() throws NetException {
    try {
      return this.systemFilePropertiesHelper.getProperty(HOSTNAME);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public final void setGateWay(final String value) throws NetException {

    try {
      this.systemFilePropertiesHelper.setProperty(new ValidatorIPFormat(),
        GATEWAY, value, this.comments);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }

  }

  @Override
  public final void setHostName(final String value) throws NetException {

    try {
      this.systemFilePropertiesHelper.setProperty(HOSTNAME, value,
        this.comments);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }

  }
}
