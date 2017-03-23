package com.kevinearls.testngtutorials;

import org.testng.annotations.BeforeClass;
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
    private static final int evenTestIterations = 100;
    @BeforeClass
    void beforeClass() {
        System.out.println(">>>>> This is the BeforeClass method; running " + evenTestIterations + " iterations");
    }

    @BeforeSuite
    void beforeSuite() {
        System.out.println(">>>>> This is the beforeSuite method");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println(">>>>> This is the beforeTest method");
    }

    @BeforeMethod
    void beforeMethod() {
        //System.out.println(">>>>> This is the beforeMethod method");
    }


    @Test
    public void firstTestNgTest() {
        System.out.println("This is a test");
    }

    @Test
    public void anotherTest() {
        System.out.println("This is anothertest");
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

    @Test(dataProvider = "getNumbers")
    public void evenTest(Integer number) throws Exception {
        //System.out.println("EvenTest invoked with " + number);
        Thread.sleep(100);
        assertTrue(number % 2 == 0, "Failed on input " + number);
    }
}
