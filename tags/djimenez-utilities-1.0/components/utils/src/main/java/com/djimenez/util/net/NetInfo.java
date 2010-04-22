package com.djimenez.util.net;

/**
 * Management for basic net info
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public interface NetInfo {

  /**
   * Get the gateway IP address.
   */
  String getGateWay() throws NetException;

  /**
   * Change the machine hostname
   */
  String getHostName() throws NetException;

  /**
   * Set the gateway IP address.
   */
  void setGateWay(final String value) throws NetException;

  /**
   * Set the machine hostname
   */
  void setHostName(final String value) throws NetException;
}
