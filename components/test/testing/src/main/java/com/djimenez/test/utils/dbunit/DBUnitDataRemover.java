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
@Deprecated
public class DBUnitDataRemover {

  private static final Logger logger =
    Logger.getLogger(DBUnitDataRemover.class);

  private IDatabaseConnection databaseConection = null;

  private static final String TRANSACTION_XML =
    "src/test/resources/dbunit/transaction.xml";

  private static final String TICKET_XML =
    "src/test/resources/dbunit/retail_transaction.xml";

  private static final String OPERATIONS_XML =
    "src/test/resources/dbunit/retail_transaction_line_items.xml";

  private static final String OPERATIONS_SALE_XML =
    "src/test/resources/dbunit/sale_line_items.xml";;

  private static final String OPERATIONS_SALE_PARKING_XML =
    "src/test/resources/dbunit/sale_line_items_parking.xml";

  private static final String OPERATIONS_SALE_CACHE_XML =
    "src/test/resources/dbunit/sale_line_items_cache.xml";

  private static final String TEST_FILE_XML =
    "src/test/resources/dbunit/test.xml";

  @Autowired
  private DataSourceTransactionManager transactionManager;

  @Test
  public void deleteOperations() {
    importFile(TRANSACTION_XML, DatabaseOperation.DELETE);
    importFile(TICKET_XML, DatabaseOperation.DELETE);
    importFile(OPERATIONS_XML, DatabaseOperation.DELETE);
    importFile(OPERATIONS_SALE_XML, DatabaseOperation.DELETE);
    importFile(OPERATIONS_SALE_PARKING_XML, DatabaseOperation.DELETE);
    importFile(OPERATIONS_SALE_CACHE_XML, DatabaseOperation.DELETE);
  }

  @Test
  public void deleteTestFile() {
    importFile(TEST_FILE_XML, DatabaseOperation.DELETE);
  }

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

  private void importFile(final String file,
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
