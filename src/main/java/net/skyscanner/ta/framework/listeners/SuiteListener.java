package net.skyscanner.ta.framework.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestNGMethod;

public class SuiteListener implements ISuiteListener {
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public void onStart(ISuite suite) {
        logger.info("Test suite - \"{}\" started", suite.getName());
        logger.info("Suite \"{}\" contains: ", suite.getName());
        for (ITestNGMethod method : suite.getAllMethods()) {
            logger.info(method.getMethodName());
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        logger.info("Test suite - {} finished", suite.getName());
        for (ISuiteResult result : suite.getResults().values()) {
            logger.info("This tests was successfully passed: ");
            logger.info(result.getTestContext().getPassedTests().getAllMethods());
            logger.info("This tests was failed: ");
            logger.info(result.getTestContext().getFailedTests().getAllMethods());
            logger.info("This tests was skipped: ");
            logger.info(result.getTestContext().getSkippedTests().getAllMethods());
        }
    }
}
