package com.djimenez.pattern.impl.servicelocator;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.djimenez.pattern.core.context.ContextHelper;
import com.djimenez.pattern.interfaces.ServiceLocator;

/**
 * A ServiceLocator implementation.
 * 
 * @author djimenez
 * @version 1.0
 */
public final class ServiceLocatorImpl implements ServiceLocator {

  private static final Logger logger =
    Logger.getLogger(ServiceLocatorImpl.class);

  private static ServiceLocator instance;
  private static ApplicationContext context;

  private ServiceLocatorImpl() {
    String[] factoryFiles = null;
    if (ContextHelper.getInstance().isWorkstationMaster().booleanValue()) {
      logger.info("Workstation Master. Loading master-beanFactoryContext.xml");
      factoryFiles = new String[] { "master-beanFactoryContext.xml" };
    }
    else {
      logger.info("Workstation Slave. Loading beanFactoryContext.xml");
      factoryFiles = new String[] { "beanFactoryContext.xml" };
    }

    context = new ClassPathXmlApplicationContext(factoryFiles);
  }

  public synchronized static ServiceLocator getInstance() {
    if (instance == null) {
      instance = new ServiceLocatorImpl();
    }
    return instance;
  }

  @Override
  public Object getBean(final String name) {
    return context.getBean(name);
  }

  @Override
  public Object getService(final String serviceName) {
    return this.getBean(serviceName);
  }
}
