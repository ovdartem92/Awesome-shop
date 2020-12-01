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

public class CommonPageElement implements PageElement {
    private static final int TIMEOUT_IN_SECONDS = 10;
    private static final int POLLING_EVERY_MILLISECONDS = 500;
    private static final String LOCATOR_NOT_NULL_MESSAGE = "Locator cannot be null.";
    private static final Logger logger = LogManager.getRootLogger();
    protected By locator;

    public CommonPageElement(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        this.locator = locator;
    }

    public CommonPageElement() {
    }

    private static Wait<? extends WebDriver> getCustomWaitConfig() {
        return getCustomWaitConfig(TIMEOUT_IN_SECONDS);
    }

    private static Wait<? extends WebDriver> getCustomWaitConfig(int timeoutInSeconds) {
        return new FluentWait<WebDriver>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(POLLING_EVERY_MILLISECONDS))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public String getAttribute(String attribute) {
        Objects.requireNonNull(attribute, "Attribute cannot be null.");
        return getAttribute(locator, attribute);
    }

    public String getAttribute(By locator, String attribute) {
        String attributeValue = "";
        try {
            Wait<? extends WebDriver> wait = getCustomWaitConfig();
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attribute);
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return attributeValue;
    }

    public static void waitForPageElementVisibilityLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForPageElementVisibilityLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementVisibilityLocated(By locator, int timeoutInSeconds) {
        try {
            Wait<? extends WebDriver> wait = getCustomWaitConfig(timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    public static void waitForPageElementInvisibilityLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForPageElementInvisibilityLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementInvisibilityLocated(By locator, int timeoutInSeconds) {
        try {
            Wait<? extends WebDriver> wait = getCustomWaitConfig(timeoutInSeconds);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    public void waitForPageElementInvisibility(int timeoutInSeconds) {
        waitForPageElementInvisibilityLocated(this.locator, timeoutInSeconds);
    }

    public static void waitForPageElementPresenceLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForPageElementPresenceLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementPresenceLocated(By locator, int timeoutInSeconds) {
        try {
            Wait<? extends WebDriver> wait = getCustomWaitConfig(timeoutInSeconds);
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
        try {
            Wait<? extends WebDriver> wait = getCustomWaitConfig(timeoutInSeconds);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    // Another methods.
    public static void waitForPageElementToBeClickable(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        waitForPageElementToBeClickable(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementToBeClickable(By locator, int timeoutInSeconds) {
        try {
            Wait<? extends WebDriver> wait = getCustomWaitConfig(timeoutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    @Override
    public boolean isSelected() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getDriver().findElement(locator).isSelected();
    }

    @Override
    public boolean isDisplay() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getDriver().findElement(locator).isDisplayed();
    }

    @Override
    public boolean isEnabled() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getDriver().findElement(locator).isEnabled();
    }

    @Override
    public String getText() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getDriver().findElement(locator).getText();
    }

    @Override
    public void click() {
        waitForPageElementToBeClickable(locator);
        Browser.getDriver().findElement(locator).click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        waitForPageElementVisibilityLocated(locator);
        Browser.getDriver().findElement(locator).sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        waitForPageElementVisibilityLocated(locator);
        Browser.getDriver().findElement(locator).clear();
    }

    @Override
    public WebElement getWrappedElement() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getDriver().findElement(locator);
    }
}
