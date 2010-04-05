package com.djimenez.test.utils.dbunit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Extract tables to XML DbUnit format using transactionManager connection
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-persistence-utils-context.xml" })
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
@Transactional
@Deprecated
public class DBUnitDataExtractor {

  private IDatabaseConnection databaseConnection = null;

  private static final String TEST_DBUNIT_XML =
    "src/test/resources/dbunit/retail_transaction_line_items.xml";

  @Autowired
  private DataSourceTransactionManager transactionManager;

  public void exportDatabase(final String databaseName,
    final String destinationFile) {

    // TODO it hasn't implemented yet. dbunit exportDatabase.
  }

  /**
   * Export table in file
   * 
   * @param table
   * @param destinationFile
   * @throws DatabaseUnitException
   * @throws SQLException
   * @throws IOException
   */
  public void exportTable(final String table, final String destinationFile) {

    try {
      this.getConection();
      // Create new DataSet
      final QueryDataSet partialDataSet =
        new QueryDataSet(this.databaseConnection);
      // Add table to dataSet
      partialDataSet.addTable(table);
      // Create output file
      final OutputStream os = new FileOutputStream(destinationFile);
      FlatXmlDataSet.write(partialDataSet, os);

    }
    catch (final Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void extractOperationsTables() {

    exportTable("RETAIL_TRANSACTION_LINE_ITEM", TEST_DBUNIT_XML);

  }

  /**
   * @return Connection from transactionManager bean
   * @throws SQLException
   * @throws DatabaseUnitException
   */
  private void getConection() throws SQLException, DatabaseUnitException {
    if (this.databaseConnection == null) {
      final Connection connection =
        this.transactionManager.getDataSource().getConnection();
      this.databaseConnection = new DatabaseConnection(connection);
    }
  }
}
