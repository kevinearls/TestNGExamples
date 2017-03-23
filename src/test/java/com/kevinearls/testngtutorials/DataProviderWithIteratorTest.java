package com.kevinearls.testngtutorials;

import com.kevinearls.testngtutorials.listeners.MyListener;
import com.kevinearls.testngtutorials.utils.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kearls on 23/03/2017.
 */
@Listeners({MyListener.class})

public class DataProviderWithIterator {
    private static final Logger logger = LoggerFactory.getLogger(DataProviderWithIterator.class);

    private NonRepeatingCounter nrc = new NonRepeatingCounter();

    @DataProvider(name = "getNumbers")
    public Iterator<Object[]> getNumbers() {
        TestData td1 = new TestData(1, 2, Arrays.asList(1, 2));
        TestData td2 = new TestData(8, 13, Arrays.asList(8, 9, 10, 12));

        Object[] data = new Object[] { td1, td2 };
        Object[] wtf1 = { new TestData(1, 2, Arrays.asList(1, 2))};
        Object[] wtf2 = { td2 };

        List<Object[]> stuff = new ArrayList<>();
        stuff.add(wtf1);
        stuff.add(wtf2);

        return stuff.iterator();
    }


    @Test(dataProvider = "getNumbers")
    public void simpleTest(TestData testData) throws Exception {
        logger.info("SimpleTest invoked with " + testData.getMinimum() + " and " + testData.getMaximum());
        logger.info("Expected: " + testData.getExpectedResultValues());



        
        
    }
}
