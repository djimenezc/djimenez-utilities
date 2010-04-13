package com.djimenez.test.example.unitils.modules.database;

import org.junit.BeforeClass;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;

@Transactional(TransactionMode.DISABLED)
public class UserDaoUnitilsTest extends UnitilsJUnit4 {

  // TODO inject the parameter with spring. The test is not working.
  // final static DataBaseUtils dataBaseUtils =
  // new DataBaseUtils("jdbc:mysql://localhost:3306/djimenez_test",
  // "org.gjt.mm.mysql.Driver", "lportal", "lportal");

  @BeforeClass
  public static void generalSetup() {

    // dataBaseUtils.resetSchema("djimenez_test");

    // dataBaseUtils
    // .executeQuery("CREATE TABLE usergroup (id INT PRIMARY KEY, name VARCHAR(10));");
    //
    // dataBaseUtils.executeQuery("CREATE TABLE user(\n"
    // + "userName VARCHAR(25) PRIMARY KEY,\n"
    // + "name VARCHAR(25),\n firstName VARCHAR(25),\n userGroup VARCHAR(25),\n"
    // + "age INT\n);");

  }

  // @AfterClass
  // public static void tearDown() {

  // dataBaseUtils.executeQuery("DROP TABLE usergroup;");
  //
  // dataBaseUtils.executeQuery("DROP TABLE user;");
  // }

  // private final UserTestDao userTestDao;

  // /**
  // *
  // */
  // public UserDaoUnitilsTest() {

  // userTestDao = new UserTestDao();
  // }

  @Test
  // @DataSet(value = { "/dbunit/unitils/UserDaoUnitilsTest.xml" })
  public void testFindByMinimalAge() {
    //
    // final List<UserTestBean> result = userTestDao.findByMinimalAge(18);
    //
    // assertPropertyLenientEquals("firstName", Arrays.asList("jack"), result);
  }

  // @Test
  // @DataSet("UserDAOTest_ages.xml")
  // public void testFindByName() {
  //
  // final UserTest result = userTestDao.findByName("doe", "john");
  //
  // assertPropertyLenientEquals("userName", "jdoe", result);
  // }
}
