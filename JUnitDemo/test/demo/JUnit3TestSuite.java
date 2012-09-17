
package demo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Sample JUnit-3-style test suite.
 * 
 * @author zhc
 */
public class JUnit3TestSuite extends TestCase {
    
    public JUnit3TestSuite(String testName) {
        super(testName);
    }            

    public static Test suite() {
        TestSuite suite = new TestSuite("JUnit3TestSuite");
        suite.addTest(new TestSuite(demo.VectorsJUnit3Test.class));
        suite.addTest(new TestSuite(demo.UtilsJUnit3Test.class));
        return suite;
    }


}
