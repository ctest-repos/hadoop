package org.apache.hadoop;

import edu.illinois.CTest;
import edu.illinois.CTestClass;
import edu.illinois.ConfigTestRunner;
import edu.illinois.UnUsedConfigParamException;

import org.apache.hadoop.conf.Configuration;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * Author: Shuai Wang
 * Date:  10/26/23
 */
@RunWith(ConfigTestRunner.class)
@CTestClass(value={"class-parameter1"}, file="src/test/resources/ExampleCTest.json")
public class ExampleCTest {
    private Configuration conf = null;
    @Before
    public void setUp() {
        conf = new Configuration();
    }

    @CTest()
    public void configTestShouldPass() {
        System.out.println("In test configTestShouldPass");
        // These two parameters are "required" in the @ConfigTestClass
        conf.get("file-parameter1");
        conf.get("file-parameter2");
        conf.get("class-parameter1");
    }

    /**
     * The test should throw an exception because the parameter "method-parameter2" is not used in the test.
     */
    @CTest(value={"method-parameter2"}, expected = UnUsedConfigParamException.class)
    public void configTestShouldFail() {
        System.out.println("In test configTestShouldFail");
        // These two parameters are "required" in the @ConfigTestClass
        conf.get("file-parameter1");
        conf.get("file-parameter2");
        conf.get("class-parameter1");
    }
}
