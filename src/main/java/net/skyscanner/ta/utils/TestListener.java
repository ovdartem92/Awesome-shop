package net.skyscanner.ta.utils;

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

/**
 * The class allows to customize the tests logs or report.
 */
public class TestListener implements ITestListener {
    private final Logger logger = LogManager.getRootLogger();

    /**
     * The method executes at the beginning of each tests and creates log with following text plus name
     * of the test class, which is running.
     *
     * @param iTestResult describes result of the tests and is used for getting name of rhe running test class.
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("Test {} STARTED.\n", iTestResult.getName());
    }

    /**
     * The method executes, when test was successfully passed and creates log with following text plus name
     * of the test class, which was running.
     *
     * @param iTestResult describes result of the tests and is used for getting name of rhe running test class.
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test {} PASSED.\n", iTestResult.getName());
    }

    /**
     * The method executes when running of the test was a failure. Create and save screenshot of
     * of current browser screen at the moment of test failed.{@link TestListener#saveScreenshot(ITestResult)}
     *
     * @param iTestResult describes result of the tests and is used for getting name of rhe running test class.
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test {} FAILED.\n", iTestResult.getName());
        saveScreenshot(iTestResult);
    }

    /**
     * The method executes when running test was skipped. Create and save screenshot of
     * of current browser screen at the moment of skipping {@link TestListener#saveScreenshot(ITestResult)}
     * This method helps to define moments whet CAPTCHA appears.
     *
     * @param iTestResult describes result of the tests and is used for getting name of rhe running test class.
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Test {} SKIPPED.\n", iTestResult.getName());
        saveScreenshot(iTestResult);
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

    /**
     * The method allows to create and save screenshot of current browser screen.
     * File will be save in target/screenshots folder and will have name consists of
     * name of running test and current date and time. Current date and time gets with method
     * {@link StringUtils#getCurrentTimeAsString()}
     *
     * @param iTestResult describes result of the tests and is used for getting name of rhe running test class.
     */
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
