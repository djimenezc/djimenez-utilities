package com.djimenez.test.dbunit;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.djimenez.model.user.User;
import com.djimenez.test.spring.dao.SpringTestDao;
import com.djimenez.test.utils.dbunit.DBUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationDBUniContext-test.xml" })
@TransactionConfiguration(transactionManager = "transacctionManager", defaultRollback = false)
@Transactional
public class DBUnitTest {

  private static final String SOURCE_DATABASE_NAME = "tmp";
  private static final String SCHEMA = "tmp";
  private static final String HSQL_FILE = "target/hsql-dbunit";
  private static final String DESTINATION_DBUNIT_XML =
    "target/mysql-dbunit.xml";
  private static final String MYSQL_DBUNIT_XML =
    "src/test/resources/mysql-dbunit.xml";

  @BeforeClass
  public static void startUp() {

    try {

      DBUnitUtils.generateXML("org.gjt.mm.mysql.Driver",
        "jdbc:mysql://localhost:3306/" + SOURCE_DATABASE_NAME, "root", "root",
        SCHEMA, DESTINATION_DBUNIT_XML);

      DBUnitUtils.createData("org.gjt.mm.mysql.Driver", "jdbc:hsqldb:file:"
        + HSQL_FILE + ";shutdown=true", "root", "root", MYSQL_DBUNIT_XML);

      DBUnitUtils.createData("org.hsqldb.jdbcDriver", "jdbc:hsqldb:file:"
        + HSQL_FILE + ";shutdown=true", "sa", "", DESTINATION_DBUNIT_XML);

    }
    catch (final Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @AfterClass
  public static void tearDown() {

    try {
      DBUnitUtils.deleteData("org.hsqldb.jdbcDriver",
        "jdbc:hsqldb:file:/tmp/appName/db/hsqldb/hibernate;shutdown=true",
        "sa", "", "dbUnit");
    }
    catch (final Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Autowired
  private SpringTestDao springTestDao;

  @Test
  public void testUserTable() {

    // Compruba la tabla de paises contenga datos
    final List<User> users = (List<User>) springTestDao.loadAll();
    Assert.assertTrue(users != null);
    Assert.assertTrue(users.size() > 0);

  }
}