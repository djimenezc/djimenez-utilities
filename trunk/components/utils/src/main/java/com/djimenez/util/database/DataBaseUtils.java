package com.djimenez.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtils {

  private String password = "";
  private String userName = "sa";
  private String dbDriver = "org.hsqldb.jdbcDriver";
  private String dbUrl = "jdbc:hsqldb:target/hsqldb/test;shutdown=true";
  private String mensajeError = "";

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

    if (hasError()) {
      return false;
    }

    try {
      sentencias = con.createStatement();
      sentencias.executeUpdate(query);
      sentencias.close();
      con.close();
    }
    catch (final Exception e) {

      mensajeError = e.getMessage();
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
      return null;
    }
    catch (final InstantiationException ie) {
      return null;
    }
    catch (final IllegalAccessException iae) {
      return null;
    }

    try {
      con = DriverManager.getConnection(this.dbUrl, username, password);
    }
    catch (final SQLException sqle) {
      return null;
    }

    return con;
  }

  public String getError() {
    return this.mensajeError;
  }

  public boolean hasError() {

    if (this.mensajeError.length() > 0) {
      return true;
    }
    return false;
  }
}
