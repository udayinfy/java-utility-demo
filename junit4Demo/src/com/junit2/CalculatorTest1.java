package com.junit2;

import junit.framework.TestCase;

public class CalculatorTest1 extends TestCase {
	
	Calculator c = new Calculator();

	protected void setUp() throws Exception {
		c.setA(2);
		c.setB(1);

	}

	protected void tearDown() throws Exception {
		c = null;
	}

	public void testAdd() {
		int result = c.add();
		assertEquals(3, result, 0);
		
	}

}
