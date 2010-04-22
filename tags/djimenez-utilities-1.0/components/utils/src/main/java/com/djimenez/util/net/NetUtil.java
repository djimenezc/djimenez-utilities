package com.djimenez.util.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import com.djimenez.util.os.unix.DCSInfoImpl;
import com.djimenez.util.os.unix.NetInfoImpl;
import com.djimenez.util.os.unix.NetServicesImpl;

/**
 * Utils for network administration.
 * 
 * @author Rodrigo Villamil Perez
 * @version 1.0
 */
public final class NetUtil {

  /**
   * La gestion de los servicios de red (NetworkServices) y la informacio de
   * configuracion de red es distinta en cada sistema operativo. En este caso
   * establecemos la implementacion para unix, pero podriamos configurarle otra
   * cualquiera.
   */
  private static NetServices netServices = new NetServicesImpl();
  private static NetInfo netInfo = new NetInfoImpl();
  private static DCSInfo dcsInfo = new DCSInfoImpl();

  // Tiempo en milisegundos de intento del ping.
  private static final int DEFAULT_TIMEOUT_PING = 5000;

  public static DCSInfo getDcsInfo() {
    return dcsInfo;
  }

  /**
   * Get all the ips that are binded to all network interface on the machine.
   * 
   * @throws NetException
   */
  public static List<String> getMyIPs() throws NetException {

    final ArrayList<String> ipList = new ArrayList<String>();

    Enumeration<NetworkInterface> nets;
    try {
      nets = NetworkInterface.getNetworkInterfaces();

      for (final NetworkInterface networkInterfaz : Collections.list(nets)) {

        final Enumeration<InetAddress> ips = networkInterfaz.getInetAddresses();
        while (ips.hasMoreElements()) {
          ipList.add(ips.nextElement().getHostAddress());
        }
      }

    }
    catch (final SocketException e) {
      throw new NetException(e);
    }

    return ipList;
  }

  /**
   * Get a list of network interfaces on the machine.
   * 
   * @throws NetException
   */
  public static List<String> getMyNetworkInterfaces() throws NetException {

    final ArrayList<String> netIfacesList = new ArrayList<String>();

    // Obtenemos todos los interfaces de red
    Enumeration<NetworkInterface> nets;
    try {
      nets = NetworkInterface.getNetworkInterfaces();

      for (final NetworkInterface networkInterfaz : Collections.list(nets)) {
        netIfacesList.add(networkInterfaz.getDisplayName());
      }

    }
    catch (final SocketException e) {
      throw new NetException(e);
    }

    return netIfacesList;
  }

  public static NetInfo getNetInfo() {
    return netInfo;
  }

  //
  // Getters And Setter
  //
  public static NetServices getNetServices() {
    return netServices;
  }

  /**
   * Send ICMP ECHO_REQUEST to network hosts (ping).
   * 
   * @see isReachable(String address, int timeout)
   * @return true, when IP is reachable.
   */
  public static boolean isReachable(final String address) throws NetException {
    return isReachable(address, DEFAULT_TIMEOUT_PING);
  }

  /**
   * Send ICMP ECHO_REQUEST to network hosts (ping). The timeout value, in
   * milliseconds, indicates the maximum amount of time the try should take. If
   * the operation times out before getting an answer, the host is deemed
   * unreachable.
   * 
   * @return true, when IP is reachable.
   */
  public static boolean isReachable(final String address, final int timeout)
    throws NetException {
    try {
      return InetAddress.getByName(address).isReachable(timeout);

    }
    catch (final UnknownHostException e) {
      throw new NetException(e);

    }
    catch (final IOException e) {
      throw new NetException(e);
    }
  }

  public static void setDcsInfo(final DCSInfo dcsInfo) {
    NetUtil.dcsInfo = dcsInfo;
  }

  public static void setNetInfo(final NetInfo netInfo) {
    NetUtil.netInfo = netInfo;
  }

  public static void setNetServices(final NetServices netServices) {
    NetUtil.netServices = netServices;
  }

  // No permitimos instancias de la clase
  private NetUtil() {
  }
}
