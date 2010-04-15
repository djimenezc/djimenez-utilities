package com.djimenez.util.os.unix;

import org.apache.log4j.Logger;

import com.djimenez.util.os.services.ServiceManagement;
import com.djimenez.util.os.services.ServiceManagementException;

/**
 * Management of Fedora Core services.
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public class ServiceManagementImpl implements ServiceManagement {

  // Comando para la gestion de los servicios red-Hat - Fedora
  private static final String CMD_SERVICE = "/sbin/service";
  private static final String CMD_SERVICE_START = "start";
  private static final String CMD_SERVICE_STOP = "stop";
  private static final String CMD_SERVICE_STATUS = "status";

  // Logger
  private static Logger logger = Logger.getLogger(ServiceManagementImpl.class);

  @Override
  public final void restart(final String service)
    throws ServiceManagementException {
    this.start(service);
    this.stop(service);
  }

  @Override
  public final void start(final String service)
    throws ServiceManagementException {

    final String command =
      ServiceManagementImpl.CMD_SERVICE + " " + service + " "
        + ServiceManagementImpl.CMD_SERVICE_START;

    try {
      LauncherProcesses.exec(command, ServiceManagementImpl.logger);

    }
    catch (final Exception e) {
      throw new ServiceManagementException(e);
    }
  }

  @Override
  public final int status(final String service)
    throws ServiceManagementException {

    final int status = 0;

    final String command =
      ServiceManagementImpl.CMD_SERVICE + " " + service + " "
        + ServiceManagementImpl.CMD_SERVICE_STATUS;

    try {
      LauncherProcesses.exec(command, ServiceManagementImpl.logger);

    }
    catch (final Exception e) {
      throw new ServiceManagementException(e);
    }

    return status;
  }

  @Override
  public final void stop(final String service)
    throws ServiceManagementException {

    final String command =
      ServiceManagementImpl.CMD_SERVICE + " " + service + " "
        + ServiceManagementImpl.CMD_SERVICE_STOP;

    try {
      LauncherProcesses.exec(command, ServiceManagementImpl.logger);
    }
    catch (final Exception e) {
      throw new ServiceManagementException(e);
    }
  }
}
