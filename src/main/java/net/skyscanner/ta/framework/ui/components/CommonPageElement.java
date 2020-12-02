package net.skyscanner.ta.framework.ui.components;

import driver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Objects;

public class CommonPageElement {
    private static final int TIMEOUT_IN_SECONDS = 10;
    private static final int POLLING_EVERY_MILLISECONDS = 500;
    private static final String LOCATOR_NOT_NULL_MESSAGE = "Locator cannot be null.";
    private static final String ATTRIBUTE_NOT_NULL_MESSAGE = "Locator cannot be null.";
    private static final String TIMEOUT_NOT_LESS_THAN_ZERO_MESSAGE = "Timeout in seconds cannot be less than 0.";
    private static final Logger logger = LogManager.getRootLogger();
    protected By locator;

    private static Wait<? extends WebDriver> getCustomWait(int timeoutInSeconds) {
        assert timeoutInSeconds < 0 : TIMEOUT_NOT_LESS_THAN_ZERO_MESSAGE;
//        return new FluentWait<>(Browser.getInstance().getWrappedDriver())
        return new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(POLLING_EVERY_MILLISECONDS))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public String getAttribute(String attribute) {
        Objects.requireNonNull(attribute, ATTRIBUTE_NOT_NULL_MESSAGE);
        return getAttribute(locator, attribute);
    }

    private String getAttribute(By locator, String attribute) {
        assert locator != null : LOCATOR_NOT_NULL_MESSAGE;
        assert attribute != null : ATTRIBUTE_NOT_NULL_MESSAGE;
        waitForPageElementPresenceLocated(locator);
//        WebDriver wrappedDriver = Browser.getInstance().getWrappedDriver();
        WebDriver wrappedDriver = Browser.getDriver();
        return wrappedDriver.findElement(locator).getAttribute(attribute).trim();
    }

    public static void waitForPageElementVisibilityLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForPageElementVisibilityLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementVisibilityLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_NOT_LESS_THAN_ZERO_MESSAGE);
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForPageElementInvisibilityLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForPageElementInvisibilityLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementInvisibilityLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_NOT_LESS_THAN_ZERO_MESSAGE);
        }
        try {
            Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    public void waitForPageElementInvisibility(int timeoutInSeconds) {
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_NOT_LESS_THAN_ZERO_MESSAGE);
        }
        waitForPageElementInvisibilityLocated(this.locator, timeoutInSeconds);
    }

    public static void waitForPageElementPresenceLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForPageElementPresenceLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementPresenceLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_NOT_LESS_THAN_ZERO_MESSAGE);
        }
        try {
            Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    public static void waitForAllElementsPresenceLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForAllElementsPresenceLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForAllElementsPresenceLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_NOT_LESS_THAN_ZERO_MESSAGE);
        }
        try {
            Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    public static void waitForPageElementToBeClickable(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForPageElementToBeClickable(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementToBeClickable(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_NOT_LESS_THAN_ZERO_MESSAGE);
        }
        try {
            Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }
}
