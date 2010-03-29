package com.germinus.sample.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public abstract class TestCase extends junit.framework.TestCase {

	protected final Log logger = LogFactory.getLog(getClass());
	
	protected static final ApplicationContext appContext;
	protected static final ApplicationContext booksPortletContext;
	//protected static final ApplicationContext dwrPortletContext;

    static {
        try {
    		appContext = new FileSystemXmlApplicationContext(
    		        new String[]{"classpath*:/context/applicationContext-web.xml"});
    		booksPortletContext = new FileSystemXmlApplicationContext(
    		        new String[]{"classpath*:/context/portlet/book-sample.xml"}, appContext);
    		/*dwrPortletContext = new FileSystemXmlApplicationContext(
    		        new String[]{"classpath*:/context/portlet/dwr-sample.xml"}, appContext);
    		        */
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

}
