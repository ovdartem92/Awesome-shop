package net.skyscanner.ta.framework.listeners;

import driver.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        logger.info("Test method {} FAILED.\n", iTestResult.getMethod().getDescription());
        saveScreenshot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Objects.requireNonNull(iTestResult, "iTestResult cannot be null.");
        logger.info("Test method {} SKIPPED.\n", iTestResult.getMethod().getDescription());
        saveScreenshot(iTestResult);
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

    public void saveScreenshot(ITestResult iTestResult) {
        File screenCapture = ((TakesScreenshot) Browser
                .initDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            Path path = Paths.get(".", "target", "screenshots", String.format("%s %s.png", iTestResult.getName(),
                    StringUtils.getCurrentTimeAsString()));
            FileUtils.copyFile(screenCapture, new File(path.toString()));
        } catch (IOException e) {
            logger.error("Failed to save screenshots {}", e.getLocalizedMessage());
        }
    }
}
