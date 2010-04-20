package com.djimenez.persistence.database.mysql;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.djimenez.test.util.dbunit.DBUnitUtils;

public class DBUnitMysqlUtils {

  private static final Log LOG = LogFactory.getLog(DBUnitMysqlUtils.class);

  private String driverName;
  private String urlDB;
  private String userDB;
  private String passwordDB;
  private String destinationXML;
  private String schemaBD;

  public final int exportDatabase() {

    int status = 1;

    try {

      DBUnitUtils.exportDatabase(driverName, urlDB, userDB, passwordDB,
        schemaBD, destinationXML);
    }
    catch (final Exception e) {

      LOG.error(e.getMessage());
      status = -1;
    }

    return status;
  }

  /**
   * @return the destinationXML
   */
  public final String getDestinationXML() {
    return destinationXML;
  }

  /**
   * @return the driverName
   */
  public final String getDriverName() {
    return driverName;
  }

  /**
   * @return the passwordDB
   */
  public final String getPasswordDB() {
    return passwordDB;
  }

  /**
   * @return the schemaBD
   */
  public final String getSchemaBD() {
    return schemaBD;
  }

  /**
   * @return the urlDB
   */
  public final String getUrlDB() {
    return urlDB;
  }

  /**
   * @return the userDB
   */
  public final String getUserDB() {
    return userDB;
  }

  public final int partialImportDatabase() {

    int status = 1;

    try {

      DBUnitUtils.importData(driverName, urlDB, userDB, passwordDB,
        destinationXML);
    }
    catch (final Exception e) {

      LOG.error(e.getMessage());
      status = -1;
    }

    return status;
  }

  /**
   * @param destinationXML
   *          the destinationXML to set
   */
  public final void setDestinationXML(final String destinationXML) {
    this.destinationXML = destinationXML;
  }

  /**
   * @param driverName
   *          the driverName to set
   */
  public final void setDriverName(final String driverName) {
    this.driverName = driverName;
  }

  /**
   * @param passwordDB
   *          the passwordDB to set
   */
  public final void setPasswordDB(final String passwordDB) {
    this.passwordDB = passwordDB;
  }

  /**
   * @param schemaBD
   *          the schemaBD to set
   */
  public final void setSchemaBD(final String schemaBD) {
    this.schemaBD = schemaBD;
  }

  /**
   * @param urlDB
   *          the urlDB to set
   */
  public final void setUrlDB(final String urlDB) {
    this.urlDB = urlDB;
  }

  /**
   * @param userDB
   *          the userDB to set
   */
  public final void setUserDB(final String userDB) {
    this.userDB = userDB;
  }

}
