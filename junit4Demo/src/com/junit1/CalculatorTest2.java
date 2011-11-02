package com.junit1;

import junit.framework.TestCase;

public class CalculatorTest2 extends TestCase { 
	
    public void testAdd(){
    	
        Calculator calcuator = new Calculator(); 
        double result=calcuator.add(1,2); 
        assertEquals(3,result,0);
        
    } 
}