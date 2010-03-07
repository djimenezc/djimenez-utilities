package com.djimenez.util.os.services;

/**
 * Management of operating system services.
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public interface ServiceManagement {

  /**
   * Start and stop the speficied operating system service.
   */
  void restart(final String service) throws ServiceManagementException;

  /**
   * Start the operating system service.
   */
  void start(final String service) throws ServiceManagementException;

  /**
   * Return service's status.
   * 
   * @return True if services is started and false otherwise.
   */
  int status(String service) throws ServiceManagementException;

  /**
   * stop the operating system service.
   */
  void stop(final String service) throws ServiceManagementException;
}
