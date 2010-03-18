package com.djimenez.test.utils.dbunit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlWriter;
import org.dbunit.operation.DatabaseOperation;

public class DBUnitUtils

{

  public static void createData(final String driverName, final String urlDB,
    final String userDB, final String passworDB, final String destinationXML)
    throws SQLException {

    Connection conn = null;

    try {
      // Connect to the database
      DriverManager.registerDriver((Driver) Class.forName(driverName)
        .newInstance());
      conn = DriverManager.getConnection(urlDB, userDB, passworDB);

      final IDatabaseConnection connection = new DatabaseConnection(conn);

      DatabaseOperation.INSERT.execute(connection, new FlatXmlDataSet(
        new FileInputStream(destinationXML)));

    }
    catch (final Exception exc) {
      exc.printStackTrace();
    }
    finally {
      conn.close();
    }
  }

  public static void createDatabase(final String driverName,
    final String urlDB, final String userDB, final String passwordDB,
    final String schemaBD) {
    // TODO createDatabase

  }

  public static void deleteData(final String driverName, final String urlDB,
    final String userDB, final String passworDB, final String nameXML)
    throws SQLException {
    Connection conn = null;
    try {
      // Connect to the database
      DriverManager.registerDriver((Driver) Class.forName(driverName)
        .newInstance());
      conn = DriverManager.getConnection(urlDB, userDB, passworDB);
      final IDatabaseConnection connection = new DatabaseConnection(conn);
      DatabaseOperation.DELETE.execute(connection, new FlatXmlDataSet(
        new FileInputStream("C:\\" + nameXML + ".xml")));

    }
    catch (final Exception exc) {
      exc.printStackTrace();
    }
    finally {
      conn.close();
    }
  }

  public static void generatePartialXML(final String driverName,
    final String urlDB, final String userDB, final String passwordDB,
    final String schemaBD, final String nameXML) throws SQLException {
    Connection conn = null;

    try {
      // Connect to the database
      DriverManager.registerDriver((Driver) Class.forName(driverName)
        .newInstance());
      conn = DriverManager.getConnection(urlDB, userDB, passwordDB);
      final IDatabaseConnection connection =
        new DatabaseConnection(conn, schemaBD);

      final QueryDataSet partialDataSet = new QueryDataSet(connection);
      // Specify the SQL to run to retrieve the data
      partialDataSet.addTable("web_direccion");
      partialDataSet.addTable("web_usuario");

      // Specify the location of the flat file(XML)
      final FlatXmlWriter datasetWriter =
        new FlatXmlWriter(new FileOutputStream("C:\\" + nameXML + ".xml"));

      // Export the data
      datasetWriter.write(partialDataSet);

    }
    catch (final Exception exc) {
      exc.printStackTrace();
    }
    finally {
      conn.close();
    }
  }

  public static void generateXML(final String driverName, final String urlDB,
    final String userDB, final String passwordDB, final String schemaBD,
    final String destinationXML) throws SQLException {

    Connection conn = null;

    try {
      // Connect to the database
      DriverManager.registerDriver((Driver) Class.forName(driverName)
        .newInstance());

      conn = DriverManager.getConnection(urlDB, userDB, passwordDB);

      final IDatabaseConnection connection =
        new DatabaseConnection(conn, schemaBD);

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

    }
    finally {
      conn.close();
    }
  }
}
