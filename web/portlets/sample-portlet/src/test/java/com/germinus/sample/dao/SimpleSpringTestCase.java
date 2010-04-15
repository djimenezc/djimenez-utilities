package com.germinus.sample.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public abstract class SimpleSpringTestCase extends junit.framework.TestCase {

  private final Log logger = LogFactory.getLog(getClass());

  private ApplicationContext appContext;
  private ApplicationContext booksPortletContext;

  // protected static final ApplicationContext dwrPortletContext;

  public SimpleSpringTestCase() {

    try {
      setAppContext(new FileSystemXmlApplicationContext(
        new String[] { "classpath*:/context/applicationContext-web.xml" }));
      setBooksPortletContext(new FileSystemXmlApplicationContext(
        new String[] { "classpath*:/context/portlet/book-sample.xml" },
        getAppContext()));
      /*
       * dwrPortletContext = new FileSystemXmlApplicationContext( new
       * String[]{"classpath*:/context/portlet/dwr-sample.xml"}, appContext);
       */
    }
    catch (final Throwable ex) {
      throw new ExceptionInInitializerError(ex);
    }
  }

  /**
   * @return the appContext
   */
  public final ApplicationContext getAppContext() {
    return appContext;
  }

  /**
   * @return the booksPortletContext
   */
  public final ApplicationContext getBooksPortletContext() {
    return booksPortletContext;
  }

  /**
   * @return the logger
   */
  public final Log getLogger() {
    return logger;
  }

  /**
   * @param appContext
   *          the appContext to set
   */
  public final void setAppContext(final ApplicationContext appContext) {
    this.appContext = appContext;
  }

  /**
   * @param booksPortletContext
   *          the booksPortletContext to set
   */
  public final void setBooksPortletContext(
    final ApplicationContext booksPortletContext) {
    this.booksPortletContext = booksPortletContext;
  }
}
