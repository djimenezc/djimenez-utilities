package com.djimenez.test.dbunit;

import org.junit.Test;

import com.djimenez.test.AbstractTest;
import com.djimenez.test.utils.dbunit.DBUnitUtils;

public class DBUnitTest extends AbstractTest {

  private static final String USER_DATABASE = "root";
  private static final String PASSWORD_DATABASE = "root";
  private static final String DRIVER_CLASS = "org.gjt.mm.mysql.Driver";
  private static final String SCHEMA = "public";
  private static final String DESTINATION_DBUNIT_XML =
    "target/mysql-dbunit.xml";
  private static final String MYSQL_DBUNIT_XML =
    "src/test/resources/common/dbunit/mysql-dbunit.xml";
  private static final String DESTINATION_DTD_XML = "target/mysql-dbunit.dtd";
  private static final String DATABASE_NAME = "tmp";

  private static final String URL_DB =
    "jdbc:mysql://localhost:3306/" + DATABASE_NAME;

  /**
   * @throws Exception
   */
  private void insertData() throws Exception {

    DBUnitUtils.importData(DRIVER_CLASS, URL_DB, USER_DATABASE, USER_DATABASE,
      MYSQL_DBUNIT_XML);
  }

  @Test
  public void testDbunitDatabase() throws Exception {

    insertData();

    DBUnitUtils.exportDatabase(DRIVER_CLASS, URL_DB, USER_DATABASE,
      PASSWORD_DATABASE, SCHEMA, DESTINATION_DBUNIT_XML);

    DBUnitUtils.exportDatabaseDtd(DRIVER_CLASS, URL_DB, USER_DATABASE,
      PASSWORD_DATABASE, DESTINATION_DTD_XML);

    DBUnitUtils.deleteData(DRIVER_CLASS, URL_DB, USER_DATABASE,
      PASSWORD_DATABASE, MYSQL_DBUNIT_XML);
  }

}