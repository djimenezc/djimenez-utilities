package com.djimenez.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataBaseUtils {

  private final transient Log log = LogFactory.getLog(getClass());

  private final String password;
  private final String userName;
  private final String dbDriver;
  private final String dbUrl;

  /**
   * @param dbUrl
   * @param dbDriver
   * @param userName
   * @param password
   */
  public DataBaseUtils(final String dbUrl, final String dbDriver,
    final String userName, final String password) {
    this.dbUrl = dbUrl;
    this.dbDriver = dbDriver;
    this.userName = userName;
    this.password = password;
  }

  public boolean executeQuery(final String query) {

    Statement sentencias = null;

    final Connection con = getConnection(userName, password);

    try {
      sentencias = con.createStatement();
      sentencias.executeUpdate(query);
      sentencias.close();
      con.close();
    }
    catch (final Exception e) {

      log.error(e.getMessage());

      return false;
    }

    return true;

  }

  public Connection getConnection(final String username, final String password) {

    Connection con = null;

    try {
      Class.forName(dbDriver).newInstance();
    }
    catch (final ClassNotFoundException cnfe) {

      log.error(cnfe.getMessage());
      return null;
    }
    catch (final InstantiationException ie) {

      log.error(ie.getMessage());
      return null;
    }
    catch (final IllegalAccessException iae) {

      log.error(iae.getMessage());
      return null;
    }

    try {
      con = DriverManager.getConnection(this.dbUrl, username, password);
    }
    catch (final SQLException sqle) {

      log.error(sqle.getMessage());
      return null;
    }

    return con;
  }

  public boolean resetSchema(final String schemaName) {

    Statement sentencias = null;

    final Connection con = getConnection(userName, password);

    try {
      sentencias = con.createStatement();
      sentencias.executeUpdate("DROP SCHEMA " + schemaName);
      sentencias.executeUpdate("CREATE SCHEMA " + schemaName);
      sentencias.close();
      con.close();
    }
    catch (final Exception e) {

      log.error(e.getMessage());

      return false;
    }

    return true;

  }

}
