package com.kevinearls.testngtutorials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Kevin Earls on 21/03/2017.
 */
public class FirstTest {
    private static final int evenTestIterations = 10;
    private static final Logger logger = LoggerFactory.getLogger(FirstTest.class);
    
    @BeforeClass
    void beforeClass() {
        logger.info(">>>>> This is the BeforeClass method; running " + evenTestIterations + " iterations");
    }

    @AfterClass
    void afterClass() {
        logger.info(">>>>> afterClass");
    }

    @BeforeSuite
    void beforeSuite() {
        logger.info(">>>>> This is the beforeSuite method");
    }

    @AfterSuite
    void afterSuite() {
        logger.info(">>>>> afterSuite");
    }

    @BeforeTest
    void beforeTest() {
        logger.info(">>>>> This is the beforeTest method");
    }

    @AfterTest
    void afterTest() {
        logger.info(">>>>> afterTest");
    }

    @BeforeMethod
    void beforeMethod() {
        logger.info(">>>>> This is the beforeMethod method");
    }

    @AfterMethod
    void afterMethod() {
        logger.info(">>>>> AfterMethod");
    }


    @BeforeGroups(groups = {"complex"})
    public void beforeComplexGroup() {
        logger.info(">>>>> beforeComplexGroup");
    }

    @BeforeGroups(groups = {"simple"})
    public void beforeSimpleGroups() {
        logger.info(">>>>> beforeSimpleGroups");
    }

    @AfterGroups
    public void afterComplexGroups() {
        logger.info(">>>>> afterComplexGroups");
    }

    @AfterGroups
    public void afterSimpleGroups() {
        logger.info(">>>> afterSimpleGroups");
    }

    @Test(groups="simple")
    public void firstTestNgTest() {
        logger.info("This is a test");
    }

    @Test(groups="simple")
    public void anotherTest() {
        logger.info("This is anothertest");
        int i = 10;
        assertEquals(i, 10);
    }


    @DataProvider(parallel = false)
    private static final Object[][] getNumbers() {
        Object[][] d = new Object[evenTestIterations][1];
        for (int i = 1; i <= evenTestIterations; i++) {
            d[i-1] = new Object[]{i * 2};
        }

        Object[][] data = new Object[][]{
                {2}, {4}, {6}
        };

        return d;
    }

    @Test(dataProvider = "getNumbers", groups="complex")
    public void evenTest(Integer number) throws Exception {
        //logger.info("EvenTest invoked with " + number);
        Thread.sleep(100);
        assertTrue(number % 2 == 0, "Failed on input " + number);
    }
}
