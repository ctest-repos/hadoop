package org.apache.hadoop;

import edu.illinois.CTest;
import edu.illinois.CTestClass;
import edu.illinois.CTestJUnit4Runner2;

import org.apache.hadoop.conf.Configuration;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(CTestJUnit4Runner2.class)
@CTestClass(value={"class-para"}, configMappingFile="ctest/saved_mapping/org.apache.hadoop.ExampleCTest.json")
public class ExampleCTest {

    private Configuration conf;

    @Before
    public void setUp() {
        conf = new Configuration();
    }

    // @CTest(value={"method-para1"})
    @CTest
    public void ExampleTestOne() {
        // conf.get("file-para");
        conf.get("class-para");
        conf.get("method-para1");
    }

    // @CTest(value={"method-para2"})
    @CTest
    public void ExampleTestTwo() {
        conf.get("file-para");
        // conf.get("class-para");
        conf.get("method-para2");
        conf.get("haha");
    }

    @CTest
    public void ExampleTestThree() {
        conf.get("file-para");
        conf.get("class-para");
        conf.get("method-para1");
        conf.get("haha");
    }

}