package com.kevinearls.testngtutorials;

import com.kevinearls.testngtutorials.listeners.MyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by kearls on 23/03/2017.
 */
@Listeners({MyListener.class})
public class AnnotationsTest {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationsTest.class);

    @Test(invocationCount = 2,priority = 3, groups = "short")
    public void test1() throws Exception {
        logger.info("Test 1 is running");
        Thread.sleep(100);
    }

    @Test(enabled = false, priority = 2, groups="short")
    public void test2() {
        logger.info("Test 2 is running");
    }

    @Test(description = "THE THIRD TEST!!!!!", priority = 0, groups = "short")
    public void test3() {
        logger.info("Test 3 is running");
        int x = 5 % 0;
    }

    @Test(description = "This test goes first", priority = 0, groups = "short", dependsOnMethods = "test3")
    public void test4() {
        logger.info("Test 4 is running");
    }

    @Test(description = "Dividing by zero is bad", expectedExceptions = ArithmeticException.class, priority = 2)
    public void divideByZeroTest() {
        logger.info("divideByZeroTest is running");
        int a = 2;
        int z = 0;
        int n = a % z;
        assertEquals(n, 4);
    }

    @Test(description = "Long test", priority = 5, timeOut = 4000)
    public void longTest() throws Exception {
        Thread.sleep(10 * 1000);
    }
}
