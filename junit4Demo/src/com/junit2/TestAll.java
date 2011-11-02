package com.junit2;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAll {

	public static Test suite() {
		
		TestSuite suite = new TestSuite("Junit Test");
		
		suite.addTestSuite(CalculatorTest1.class);
		suite.addTestSuite(CalculatorTest2.class);
		
		return suite;
	}

}
