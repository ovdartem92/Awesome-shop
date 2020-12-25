package ru.awesome.shop.ta.framework.ui.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.logging.Log;

import java.time.Duration;
import java.util.Objects;

public class CommonPageElement {
    private static final int TIMEOUT_IN_SECONDS = 10;
    private static final int POLLING_EVERY_MILLISECONDS = 500;
    protected By locator;

    private static Wait<? extends WebDriver> getCustomWait(int timeoutInSeconds) {
        assert timeoutInSeconds >= 0 : "Timeout in seconds cannot be less than 0.";
        return new FluentWait<>(Browser.getInstance().getWrappedDriver())
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(POLLING_EVERY_MILLISECONDS))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public static String getAttribute(By locator, String attribute) {
        assert locator != null : "Locator cannot be null.";
        assert attribute != null : "Attribute cannot be null.";
        waitForPageElementPresenceLocated(locator);
        WebDriver wrappedDriver = Browser.getInstance().getWrappedDriver();
        return wrappedDriver.findElement(locator).getAttribute(attribute).trim();
    }

    public static void waitForPageElementVisibilityLocated(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        waitForPageElementVisibilityLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementVisibilityLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException("Timeout in seconds cannot be less than 0.");
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForAllPageElementsVisibilityLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException("Timeout in seconds cannot be less than 0.");
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void waitForPageElementInvisibilityLocated(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        waitForPageElementInvisibilityLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementInvisibilityLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException("Timeout in seconds cannot be less than 0.");
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForPageElementPresenceLocated(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        waitForPageElementPresenceLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementPresenceLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException("Timeout in seconds cannot be less than 0.");
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForAllElementsPresenceLocated(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        waitForAllElementsPresenceLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForAllElementsPresenceLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException("Timeout in seconds cannot be less than 0.");
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static void waitForPageElementToBeClickable(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        waitForPageElementToBeClickable(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementToBeClickable(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException("Timeout in seconds cannot be less than 0.");
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean isAllElementsVisible(By locator, int timeoutInSeconds) {
        try {
            waitForAllPageElementsVisibilityLocated(locator, timeoutInSeconds);
            return true;
        } catch (TimeoutException e) {
            Log.debug("No element found on current page.");
            return false;
        }
    }
}
