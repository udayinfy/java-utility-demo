package com.junit1;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class TestAll extends TestSuite { 
	
	public static void main(String args[]){
        TestRunner.run(suite()); 
    } 
	
    public static Test suite() {
        TestSuite suite = new TestSuite("Junit Test"); 
        suite.addTestSuite(CalculatorTest1.class); 
        suite.addTestSuite(CalculatorTest2.class); 
        return suite; 
    } 
    
}