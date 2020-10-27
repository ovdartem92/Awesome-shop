package net.skyscanner.util;

import net.skyscanner.driver.Browser;
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
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info(String.format("Test [%s] started.\n", iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(String.format("Test [%s] PASSED.\n", iTestResult.getName()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info(String.format("Test [%s] FAILED.\n", iTestResult.getName()));
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info(String.format("Test [%s] SKIPPED.\n", iTestResult.getName()));
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
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            Path path = Paths.get(String.format("./target/screenshots/%s.png", getCurrentTimeAsString()));
            FileUtils.copyFile(screenCapture, new File(path.toString()));
        } catch (IOException e) {
            logger.error("Failed to save screenshots" + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
