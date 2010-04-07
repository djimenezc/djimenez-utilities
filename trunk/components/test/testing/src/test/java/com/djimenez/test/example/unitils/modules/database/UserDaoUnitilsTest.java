package com.djimenez.test.example.unitils.modules.database;

import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.datasetloadstrategy.impl.InsertLoadStrategy;

import com.djimenez.test.example.unitils.dao.UserTestDao;
import com.djimenez.test.model.UserTest;
import com.djimenez.util.database.DataBaseUtils;

@Transactional(TransactionMode.DISABLED)
public class UserDaoUnitilsTest extends UnitilsJUnit4 {

  @BeforeClass
  public static void generalSetup() {

    final DataBaseUtils dataBaseUtils =
      new DataBaseUtils("jdbc:hsqldb:target/hsqldb/public;shutdown=true",
        "org.hsqldb.jdbcDriver", "sa", "");

    dataBaseUtils.executeQuery("DROP SCHEMA PUBLIC CASCADE ;");

    dataBaseUtils
      .executeQuery("CREATE TABLE usergroup (name VARCHAR(25) PRIMARY KEY)");

    dataBaseUtils.executeQuery("CREATE TABLE user(\n"
      + "userName VARCHAR(25) PRIMARY KEY,\n"
      + "name VARCHAR(25),\n firstname VARCHAR(25),\n userGroup VARCHAR(25),\n"
      + "age INT\n);");

  }

  private final UserTestDao userTestDao;

  /**
   * 
   */
  public UserDaoUnitilsTest() {

    userTestDao = new UserTestDao();
  }

  @Test
  @DataSet(loadStrategy = InsertLoadStrategy.class, value = { "/dbunit/unitils/UserDaoUnitilsTest.xml" })
  public void testFindByMinimalAge() {

    final List<UserTest> result = userTestDao.findByMinimalAge(18);

    assertPropertyLenientEquals("firstName", Arrays.asList("jack"), result);
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
