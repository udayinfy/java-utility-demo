
package demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Sample JUnit-4-style test suite.
 * 
 * @author zhc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({demo.VectorsJUnit4Test.class,demo.UtilsJUnit4Test.class})
public class JUnit4TestSuite {

}
