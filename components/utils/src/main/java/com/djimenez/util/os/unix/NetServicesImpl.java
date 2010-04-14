package com.djimenez.util.os.unix;

import java.io.IOException;

import com.djimenez.util.net.NetException;
import com.djimenez.util.net.NetServices;
import com.djimenez.util.os.configuration.files.types.SystemFilePropertiesHelper;
import com.djimenez.util.os.configuration.files.validators.ValidatorIPFormat;
import com.djimenez.util.os.services.ServiceManagement;
import com.djimenez.util.os.services.ServiceManagementException;

/**
 * Management of net configuration files and services on a distribution based on
 * Red-Hat.(Fedora) In general: /etc/sysconfig/network-scripts/ifcfg-eth0
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public class NetServicesImpl implements NetServices {

  // Logger
  // private static final Logger logger = Logger.getLogger(NetInfoImpl.class);

  // Fichero asociado a la informacion de red
  private static final String DEFAULT_FILE =
    "/etc/sysconfig/network-scripts/ifcfg-eth0";

  private static final String NETWORK_SERVICE = "network";

  // Properties - Keys
  private static final String IPADDR = "IPADDR";
  private static final String BROADCAST = "BROADCAST";
  private static final String NETMASK = "NETMASK";
  private static final String NETWORK = "NETWORK";

  // Administracion de servicios Fedora
  ServiceManagement serviceManagement = new ServiceManagementImpl();
  // Wrapper for properties file
  private final SystemFilePropertiesHelper systemFilePropertiesHelper =
    new SystemFilePropertiesHelper();

  // Getters and setters
  private String comments = null;

  public NetServicesImpl() {
    this.systemFilePropertiesHelper.setPathFile(DEFAULT_FILE);
  }

  public NetServicesImpl(final String pathFile) {
    this.systemFilePropertiesHelper.setPathFile(pathFile);
  }

  @Override
  public void bringUp(final String networkInterface) throws NetException {
    try {
      this.serviceManagement.start(NETWORK_SERVICE);
    }
    catch (final ServiceManagementException e) {
      throw new NetException(e);
    }
  }

  @Override
  public void down(final String networkInterface) throws NetException {
    try {
      this.serviceManagement.stop(NETWORK_SERVICE);
    }
    catch (final ServiceManagementException e) {
      throw new NetException(e);
    }
  }

  @Override
  public String getBroadCast() throws NetException {
    try {
      return this.systemFilePropertiesHelper.getProperty(BROADCAST);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  //
  // Getters and Setters
  //
  public String getComments() {
    return this.comments;
  }

  @Override
  public String getIPaddr() throws NetException {
    try {
      return this.systemFilePropertiesHelper.getProperty(IPADDR);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public String getNetMask() throws NetException {
    try {
      return this.systemFilePropertiesHelper.getProperty(NETMASK);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public String getNetwork() throws NetException {
    try {
      return this.systemFilePropertiesHelper.getProperty(NETWORK);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public void setBroadCast(final String value) throws NetException {
    try {
      this.systemFilePropertiesHelper.setProperty(new ValidatorIPFormat(),
        BROADCAST, value, this.comments);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  @Override
  public void setIPaddr(final String value) throws NetException {

    try {
      this.systemFilePropertiesHelper.setProperty(new ValidatorIPFormat(),
        IPADDR, value, this.comments);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public void setNetMask(final String value) throws NetException {

    try {
      this.systemFilePropertiesHelper.setProperty(new ValidatorIPFormat(),
        NETMASK, value, this.comments);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  @Override
  public void setNetwork(final String value) throws NetException {
    try {
      this.systemFilePropertiesHelper.setProperty(new ValidatorIPFormat(),
        NETWORK, value, this.comments);
    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }
}
