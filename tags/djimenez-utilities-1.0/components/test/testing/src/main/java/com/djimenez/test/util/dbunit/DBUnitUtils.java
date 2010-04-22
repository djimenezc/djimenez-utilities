package com.djimenez.test.util.dbunit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlWriter;
import org.dbunit.operation.DatabaseOperation;

public class DBUnitUtils {

  public static void deleteData(final String driverName, final String urlDB,
    final String userDB, final String passwordDB, final String deleteXml)
    throws Exception {

    IDatabaseConnection connection = null;

    try {
      // Connect to the database
      connection =
        openDatabaseConnection(driverName, urlDB, userDB, passwordDB);

      DatabaseOperation.DELETE.execute(connection, new FlatXmlDataSet(
        new FileInputStream(deleteXml)));
    }
    catch (final Exception exc) {
      exc.printStackTrace();
      throw exc;
    }
    finally {
      connection.close();
    }
  }

  public static void exportDatabase(final String driverName,
    final String urlDB, final String userDB, final String passwordDB,
    final String schemaBD, final String destinationXML) throws Exception {

    IDatabaseConnection connection = null;

    try {
      // Connect to the database
      connection =
        openDatabaseConnection(driverName, urlDB, userDB, passwordDB);

      final DatabaseSequenceFilter filter =
        new DatabaseSequenceFilter(connection);

      final IDataSet datasetAll =
        new FilteredDataSet(filter, connection.createDataSet());

      final QueryDataSet partialDataSet = new QueryDataSet(connection);

      final String[] listTableNames = filter.getTableNames(datasetAll);

      for (final String tableName : listTableNames) {
        // Specify the SQL to run to retrieve the data
        partialDataSet.addTable(tableName);

      }

      final OutputStream outputStream = new FileOutputStream(destinationXML);

      // Specify the location of the flat file(XML)
      final FlatXmlWriter datasetWriter = new FlatXmlWriter(outputStream);

      // Export the data
      datasetWriter.write(partialDataSet);

    }
    catch (final Exception exc) {
      exc.printStackTrace();
      throw exc;
    }
    finally {
      connection.close();
    }
  }

  public static void exportDatabaseDtd(final String driverName,
    final String urlDB, final String userDB, final String passwordDB,
    final String fileDtd) throws SQLException {

    IDatabaseConnection connection = null;

    try {
      // Connect to the database
      connection =
        openDatabaseConnection(driverName, urlDB, userDB, passwordDB);

      // write DTD file
      FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream(
        fileDtd));
    }
    catch (final Exception exc) {
      exc.printStackTrace();
    }
    finally {
      connection.close();
    }

  }

  private static Connection getConection(final String driverName,
    final String urlDB, final String userDB, final String passwordDB)
    throws SQLException, InstantiationException, IllegalAccessException,
    ClassNotFoundException {

    Connection conn = null;

    // Connect to the database
    DriverManager.registerDriver((Driver) Class.forName(driverName)
      .newInstance());

    conn = DriverManager.getConnection(urlDB, userDB, passwordDB);

    return conn;
  }

  public static void importData(final String driverName, final String urlDB,
    final String userDB, final String passwordDB, final String destinationXML)
    throws SQLException {

    IDatabaseConnection connection = null;

    try {
      connection =
        openDatabaseConnection(driverName, urlDB, userDB, passwordDB);

      DatabaseOperation.INSERT.execute(connection, new FlatXmlDataSet(
        new FileInputStream(destinationXML)));

    }
    catch (final Exception exc) {
      exc.printStackTrace();
    }
    finally {
      connection.close();
    }
  }

  public static IDatabaseConnection openDatabaseConnection(
    final String driverName, final String urlDB, final String userDB,
    final String passwordDB) throws DatabaseUnitException, SQLException,
    InstantiationException, IllegalAccessException, ClassNotFoundException {

    final Connection conn = getConection(driverName, urlDB, userDB, passwordDB);

    final IDatabaseConnection connection = new DatabaseConnection(conn);

    return connection;
  }

  public static IDatabaseConnection openDatabaseConnection(
    final String driverName, final String urlDB, final String userDB,
    final String passwordDB, final String schemaBD) throws SQLException,
    InstantiationException, IllegalAccessException, ClassNotFoundException,
    DatabaseUnitException {

    final Connection conn = getConection(driverName, urlDB, userDB, passwordDB);

    final IDatabaseConnection connection =
      new DatabaseConnection(conn, schemaBD);

    return connection;
  }

  public static void partialExportDatabase(final String driverName,
    final String urlDB, final String userDB, final String passwordDB,
    final String schemaBD, final List<String> tables,
    final String destinationXml) throws Exception {

    IDatabaseConnection connection = null;

    try {
      // Connect to the database
      connection =
        openDatabaseConnection(driverName, urlDB, userDB, passwordDB, schemaBD);

      final QueryDataSet partialDataSet = new QueryDataSet(connection);
      // Specify the SQL to run to retrieve the data

      for (final String table : tables) {

        partialDataSet.addTable(table);
      }

      // Specify the location of the flat file(XML)
      final FlatXmlWriter datasetWriter =
        new FlatXmlWriter(new FileOutputStream(destinationXml));

      // Export the data
      datasetWriter.write(partialDataSet);

    }
    catch (final Exception exc) {
      exc.printStackTrace();
      throw exc;
    }
    finally {
      connection.close();
    }
  }
}
