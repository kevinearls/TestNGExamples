package com.kevinearls.testngtutorials;

import com.kevinearls.testngtutorials.utils.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by kearls on 21/03/2017.
 */
public class NonRepeatingCounterTest {

    private NonRepeatingCounter nrc;
    private static final Logger logger = LoggerFactory.getLogger(NonRepeatingCounterTest.class);

    @BeforeMethod
    public void setup() {
        nrc = new NonRepeatingCounter();
    }

    @DataProvider(parallel = false)
    private final Object[][] getNumbers() {
        List<Integer> x = Arrays.asList(8, 9, 10, 11, 12);
        TestData td1 = new TestData(1, 2, Arrays.asList(1, 2));

        Object[][] data = new Object[][] {
                /*{8, 13, 8, 9, 10, 12},
                {98,105, 0, 1, 2},
                {5432, 5438, 5432, 5436, 5435}  */
                {new TestData(8, 13, Arrays.asList(8, 9, 10, 12))}
        };

        return data;
    }

    @Test(dataProvider = "getNumbers")
    public void simpleTest(TestData testData) throws Exception {
        logger.info("SimpleTest invoked with " + testData.getMinimum() + " and " + testData.getMaximum());
        logger.info("Expected: " + testData.getExpectedResultValues());

        List<String> numbers = nrc.getNotRepeatingNumbers(testData.getMinimum(), testData.getMaximum());
        logger.info("NRC Returned: " + numbers.toString());
    }

}
