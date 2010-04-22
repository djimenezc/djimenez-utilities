package com.djimenez.util.os.unix;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.djimenez.util.os.services.ServiceManagement;
import com.djimenez.util.os.services.ServiceManagementException;

/**
 * Main class to management red-hat - fedora services.
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public final class ServiceManagementApplication {

  private static final Log LOG =
    LogFactory.getLog(ServiceManagementApplication.class);

  /**
   * @param args
   * @throws ServiceManagementException
   */
  public static void main(final String[] args)
    throws ServiceManagementException {
    final ServiceManagement services = new ServiceManagementImpl();

    final String serviceName = args[0];
    final String operation = args[1];

    LOG.info(operation + " service " + serviceName);

    if (operation.equals("start")) {
      services.start(serviceName);

    }
    else
      if (operation.equals("stop")) {
        services.stop(serviceName);

      }
      else
        if (operation.equals("restart")) {
          services.restart(serviceName);

        }
        else
          if (operation.equals("status")) {
            services.status(serviceName);
          }
  }

  private ServiceManagementApplication() {

  }
}
