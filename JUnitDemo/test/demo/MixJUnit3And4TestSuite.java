
package demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author nb
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({demo.JUnit4TestSuite.class,demo.VectorsJUnit3Test.class})
public class MixJUnit3And4TestSuite {

}