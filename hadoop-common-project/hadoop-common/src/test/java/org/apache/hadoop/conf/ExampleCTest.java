package org.apache.hadoop.conf;

import edu.illinois.CTest;
import edu.illinois.CTestClass;
import edu.illinois.CTestJUnit4Runner;
import edu.illinois.UnUsedConfigParamException;
import org.junit.runner.RunWith;

/**
 * Author: Shuai Wang
 * Date:  11/13/23
 */
@RunWith(CTestJUnit4Runner.class)
@CTestClass(value = {"class-parameter1", "class-parameter2"})
public class ExampleCTest {
    /**
     * The test would pass because it uses all the "required" configuration parameters from class annotation, file path, and method annotation.
     */
    @CTest({"method-parameter1", "method-parameter2"})
    public void test() {
        Configuration conf = new Configuration();
        // From class annotation
        conf.get("class-parameter1");
        conf.get("class-parameter2");
        // From file path
        conf.get("file-param1");
        // From method annotation
        conf.get("method-parameter1");
        conf.get("method-parameter2");
    }

    /**
     * The test would fail because it never uses "method-parameter2".
     */
    @CTest(value = {"method-parameter1", "method-parameter2"}, expected = UnUsedConfigParamException.class)
    public void testFailDueToMethodAnnotation() {
        Configuration conf = new Configuration();
        // From class annotation
        conf.get("class-parameter1");
        conf.get("class-parameter2");
        // From file path
        conf.get("file-param1");
        // From method annotation
        conf.get("method-parameter1");
        // Missing method-parameter2 so the test would fail
    }
}