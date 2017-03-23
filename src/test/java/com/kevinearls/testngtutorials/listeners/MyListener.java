package com.kevinearls.testngtutorials.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by kearls on 23/03/2017.
 */
public class MyListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String name = iTestResult.getName();
        String instanceName = iTestResult.getInstanceName();
        logger.info(">>>> In onTestStart for " + instanceName + "#" + name);

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
