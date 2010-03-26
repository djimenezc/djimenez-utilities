package com.carbonfive.testutils.dbunit;

import java.io.InputStream;

import javax.sql.DataSource;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.util.ClassUtils;

public class DatasetUtils {

  @SuppressWarnings("unchecked")
  public static void loadDataSet(final Class clazz, final DataSource dataSource)
    throws Exception {

    final IDataSet dataSet = new FlatXmlDataSet(datasetInputStream(clazz));
    final IDatabaseTester tester =
      new ExistingConnectionDatabaseTester(dataSource);
    tester.setDataSet(dataSet);
    tester.onSetup();
  }

  @SuppressWarnings("unchecked")
  private static InputStream datasetInputStream(final Class clazz) {
    return clazz.getResourceAsStream(ClassUtils.getShortName(clazz) + ".xml");
  }

}
