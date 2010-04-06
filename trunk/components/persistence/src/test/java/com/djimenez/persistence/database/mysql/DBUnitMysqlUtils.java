package com.djimenez.persistence.database.mysql;

import com.djimenez.test.utils.dbunit.DBUnitUtils;

public class DBUnitMysqlUtils {

  private String driverName;
  private String urlDB;
  private String userDB;
  private String passwordDB;
  private String destinationXML;
  private String schemaBD;

  public int exportDatabase() {

    int status = 1;

    try {

      DBUnitUtils.exportDatabase(driverName, urlDB, userDB, passwordDB,
        schemaBD, destinationXML);
    }
    catch (final Exception e) {
      e.printStackTrace();

      status = -1;
    }

    return status;
  }

  /**
   * @return the destinationXML
   */
  public String getDestinationXML() {
    return destinationXML;
  }

  /**
   * @return the driverName
   */
  public String getDriverName() {
    return driverName;
  }

  /**
   * @return the passwordDB
   */
  public String getPasswordDB() {
    return passwordDB;
  }

  /**
   * @return the schemaBD
   */
  public String getSchemaBD() {
    return schemaBD;
  }

  /**
   * @return the urlDB
   */
  public String getUrlDB() {
    return urlDB;
  }

  /**
   * @return the userDB
   */
  public String getUserDB() {
    return userDB;
  }

  public int partialImportDatabase() {

    int status = 1;

    try {

      DBUnitUtils.importData(driverName, urlDB, userDB, passwordDB,
        destinationXML);
    }
    catch (final Exception e) {
      e.printStackTrace();

      status = -1;
    }

    return status;
  }

  /**
   * @param destinationXML
   *          the destinationXML to set
   */
  public void setDestinationXML(final String destinationXML) {
    this.destinationXML = destinationXML;
  }

  /**
   * @param driverName
   *          the driverName to set
   */
  public void setDriverName(final String driverName) {
    this.driverName = driverName;
  }

  /**
   * @param passwordDB
   *          the passwordDB to set
   */
  public void setPasswordDB(final String passwordDB) {
    this.passwordDB = passwordDB;
  }

  /**
   * @param schemaBD
   *          the schemaBD to set
   */
  public void setSchemaBD(final String schemaBD) {
    this.schemaBD = schemaBD;
  }

  /**
   * @param urlDB
   *          the urlDB to set
   */
  public void setUrlDB(final String urlDB) {
    this.urlDB = urlDB;
  }

  /**
   * @param userDB
   *          the userDB to set
   */
  public void setUserDB(final String userDB) {
    this.userDB = userDB;
  }

}
