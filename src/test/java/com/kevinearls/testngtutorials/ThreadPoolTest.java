package com.kevinearls.testngtutorials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kearls on 23/03/2017.
 */
public class ThreadPoolTest {
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolTest.class);

    AtomicInteger instance = new AtomicInteger(1);

    @Test(threadPoolSize = 8, invocationCount = 20)
    public void simpleTest() throws Exception {
        int instanceId = instance.getAndIncrement();
        logger.info("Starting instance " + instanceId);
        Thread.sleep(2500);
        logger.info("Exiting instance " + instanceId);
    }
    
}
