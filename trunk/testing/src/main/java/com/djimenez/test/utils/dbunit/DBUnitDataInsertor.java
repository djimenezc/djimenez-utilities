package com.djimenez.test.utils.dbunit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Import tables from XML DbUnit format using transactionManager connection
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-persistence-utils-context.xml" })
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
@Transactional
public class DBUnitDataInsertor {

  private static final Logger logger =
    Logger.getLogger(DBUnitDataInsertor.class);

  private IDatabaseConnection databaseConection = null;

  private static final String TEST_FILE_XML =
    "src/test/resources/dbunit/test.xml";

  @Autowired
  private DataSourceTransactionManager transactionManager;

  /**
   * @return Connection from transactionManager bean
   * @throws SQLException
   * @throws DatabaseUnitException
   */
  private void getConection() throws SQLException, DatabaseUnitException {

    if (databaseConection == null) {
      final Connection connection =
        transactionManager.getDataSource().getConnection();
      this.databaseConection = new DatabaseConnection(connection);
    }

  }

  @Test
  public void insertTestFile() {
    inserttFile(TEST_FILE_XML, DatabaseOperation.INSERT);
  }

  private void inserttFile(final String file,
    final DatabaseOperation databaseOperation) {

    try {
      this.getConection();
      final FileInputStream fileInput = new FileInputStream(file);
      final IDataSet dataSet = new FlatXmlDataSet(fileInput);
      databaseOperation.execute(this.databaseConection, dataSet);

    }
    catch (final SQLException e) {
      logger.info(e.getMessage());
    }
    catch (final DatabaseUnitException e) {
      logger.info(e.getMessage());
    }
    catch (final FileNotFoundException e) {
      logger.info(e.getMessage());
    }
    catch (final IOException e) {
      logger.info(e.getMessage());
    }
  }

}
