package net.skyscanner.ta.framework.listeners;

import net.skyscanner.ta.framework.browser.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Objects;

public class TestListener implements ITestListener {
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        logger.info("Test method {} STARTED.\n", iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        logger.info("Test method {} SUCCESSFULLY PASSED.\n", iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        logger.error("Test method {} FAILED.\n", iTestResult.getMethod().getDescription());
        File screenshot = Browser.getInstance().takeScreenshot();
        String screenshotTag = String.format("<a href='../../screenshots/%s'><img src='../../screenshots/%s' "
                + "height='304' width='525'/></a>", screenshot.getName(), screenshot.getName());
        logger.info("Screenshot {} was saved", screenshotTag);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        logger.info("Test method {} SKIPPED.\n", iTestResult.getMethod().getDescription());
        File screenshot = Browser.getInstance().takeScreenshot();
        String screenshotTag = String.format("<a href='../../screenshots/%s'><img src='../../screenshots/%s' "
                + "height='304' width='525'/></a>", screenshot.getName(), screenshot.getName());
        logger.info("Screenshot {} was saved", screenshotTag);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "ITestResult cannot be null");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Objects.requireNonNull(iTestContext, "iTestContext cannot be null.");
        logger.info("Test {} STARTED.\n", iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Objects.requireNonNull(iTestContext, "iTestContext cannot be null.");
        logger.info("Test {} FINISHED.\n", iTestContext.getName());
    }
}
