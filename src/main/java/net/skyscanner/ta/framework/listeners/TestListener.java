package net.skyscanner.ta.framework.listeners;

import net.skyscanner.ta.framework.browser.Browser;
import net.skyscanner.ta.framework.logging.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Objects;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        Log.info(String.format("Test method %s STARTED.", iTestResult.getMethod().getDescription()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        Log.info(String.format("Test method %s SUCCESSFULLY PASSED", iTestResult.getMethod().getDescription()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        Log.info(String.format("Test method %s FAILED.", iTestResult.getMethod().getDescription()));
        File screenshot = Browser.getInstance().takeScreenshot();
        String screenshotTag = String.format("<a href='../../screenshots/%s'><img src='../../screenshots/%s' "
                + "height='304' width='525'/></a>", screenshot.getName(), screenshot.getName());
        Log.info(String.format("Screenshot %s was saved", screenshotTag));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        Log.info(String.format("Test method %s SKIPPED.", iTestResult.getMethod().getDescription()));
        File screenshot = Browser.getInstance().takeScreenshot();
        String screenshotTag = String.format("<a href='../../screenshots/%s'><img src='../../screenshots/%s' "
                + "height='304' width='525'/></a>", screenshot.getName(), screenshot.getName());
        Log.info(String.format("Screenshot %s was saved", screenshotTag));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "ITestResult cannot be null");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Objects.requireNonNull(iTestContext, "iTestContext cannot be null.");
        Log.info(String.format("Test %s STARTED.", iTestContext.getName()));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Objects.requireNonNull(iTestContext, "iTestContext cannot be null.");
        Log.info(String.format("Test %s FINISHED.", iTestContext.getName()));
    }
}
