package com.djimenez.util.net;

/**
 * Management for basic DCS configuration
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public interface DCSInfo {

  /**
   * Get the IP for DCS
   */
  String getIP() throws NetException;

  /**
   * Change the IP for DCS
   */
  void setIP(final String value) throws NetException;

}
