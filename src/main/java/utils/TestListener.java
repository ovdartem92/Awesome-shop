package utils;

import driver.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestListener implements ITestListener {
    private Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("Test {} STARTED.\n", iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test {} PASSED.\n", iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test {} FAILED.\n", iTestResult.getName());
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Test {} SKIPPED.\n", iTestResult.getName());
        saveScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // unused at the moment
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // unused at the moment
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // unused at the moment
    }

    public void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) Browser
                .initDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            Path path = Paths.get(".", "target", "screenshots", String.format("%s.png", StringUtils.getCurrentTimeAsString()));
            FileUtils.copyFile(screenCapture, new File(path.toString()));
        } catch (IOException e) {
            logger.error("Failed to save screenshots {}", e.getLocalizedMessage());
        }
    }
}
