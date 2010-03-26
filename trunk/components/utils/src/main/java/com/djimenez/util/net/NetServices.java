package com.djimenez.util.net;

/**
 * Information and administration about net services and configuration
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public interface NetServices {

  /**
   * Bring up the network interface.
   */
  void bringUp(final String networkInterface) throws NetException;

  /**
   * Down the network interface.
   */
  void down(final String networkInterface) throws NetException;

  /**
   * Get the IP broadcast in net configuration file.Null if it did not have one.
   */
  String getBroadCast() throws NetException;

  /**
   * Get the IP address in net configuration file.Null if it did not have one.
   */
  String getIPaddr() throws NetException;

  /**
   * Get net mask in net configuration file.Null if it did not have one.
   */
  String getNetMask() throws NetException;

  /**
   * Get the network IP in net configuration file.Null if it did not have one.
   */
  String getNetwork() throws NetException;

  /**
   * Change well-formed valid broadcast ip in net configuration file.
   */
  void setBroadCast(final String value) throws NetException;

  /**
   * Change well-formed valid IP address in net configuration file.
   */
  void setIPaddr(final String value) throws NetException;

  /**
   * Change well-formed valid net mask in net configuration file.
   */
  void setNetMask(final String value) throws NetException;

  /**
   * Change well-formed valid network ip in net configuration file.
   */
  void setNetwork(final String value) throws NetException;
}
