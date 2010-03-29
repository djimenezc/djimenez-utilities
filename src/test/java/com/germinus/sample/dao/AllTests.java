package com.germinus.sample.dao;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		
		TestSuite suite = new TestSuite("Test for com.germinus.sample.dao");
		
		//$JUnit-BEGIN$
		suite.addTestSuite(TestBookViewController.class);
		//$JUnit-END$
		
		return suite;
		
	}
}
