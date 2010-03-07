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
  private final String DEFAULT_FILE = "/etc/sysconfig/network";

  private final String HOSTNAME = "HOSTNAME";
  private final String GATEWAY = "GATEWAY";

  // Wrapper for properties file
  private final SystemFilePropertiesHelper systemFilePropertiesHelper =
    new SystemFilePropertiesHelper();

  // Getters and setters
  private final String comments = null;

  public NetInfoImpl() {
    this.systemFilePropertiesHelper.setPathFile(this.DEFAULT_FILE);
  }

  public NetInfoImpl(final String pathFile) {
    this.systemFilePropertiesHelper.setPathFile(pathFile);
  }

  @Override
  public String getGateWay() throws NetException {

    try {
      return this.systemFilePropertiesHelper.getProperty(this.GATEWAY);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public String getHostName() throws NetException {
    try {
      return this.systemFilePropertiesHelper.getProperty(this.HOSTNAME);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public void setGateWay(final String value) throws NetException {

    try {
      this.systemFilePropertiesHelper.setProperty(new ValidatorIPFormat(),
        this.GATEWAY, value, this.comments);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }

  }

  @Override
  public void setHostName(final String value) throws NetException {

    try {
      this.systemFilePropertiesHelper.setProperty(this.HOSTNAME, value,
        this.comments);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }

  }
}
