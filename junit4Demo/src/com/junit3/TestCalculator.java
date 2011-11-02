
package com.junit3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.junit1.Calculator;


public class TestCalculator {
	
	@Before
    public void setUp() throws Exception {
		//TODO
    }

    @After
    public void tearDown() throws Exception {
    	//TODO
    }
    
    @Test
    public void add(){
        Calculator calcuator = new Calculator(); 
    	double result = calcuator.add(1,2);
    	assertEquals(3,result,0);
    }

}
