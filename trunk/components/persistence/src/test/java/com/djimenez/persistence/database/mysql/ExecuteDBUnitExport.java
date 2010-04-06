package com.djimenez.persistence.database.mysql;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class ExecuteDBUnitExport {

  public static void main(final String... args) {

    final Resource res =
      new FileSystemResource(
        "target/test-classes/context/dbunit/applicationContext-dbunit.xml");
    final XmlBeanFactory beanFactory = new XmlBeanFactory(res);

    final DBUnitMysqlUtils dbUnitMysqlUtils =
      (DBUnitMysqlUtils) beanFactory.getBean("dbUnitMysqlUtils");

    dbUnitMysqlUtils.exportDatabase();

  }

}
