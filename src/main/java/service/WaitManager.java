package service;

import driver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class WaitManager {
    private static final long PULLING_EVERY_MILLIS_SECONDS = 300;
    private static Wait<WebDriver> wait;

    public static Wait<WebDriver> getDefaultWaitConfig() {
        return new FluentWait<>(Browser.initDriver())
                .withTimeout(Duration.ofSeconds(Browser.DEFAULT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofMillis(PULLING_EVERY_MILLIS_SECONDS))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public static boolean isElementVisible(String locatorPath) {
        wait = getDefaultWaitConfig();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean isElementVisible(long timeout, String locatorPath) {
        try {
            new WebDriverWait(Browser.initDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorPath)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(String locatorPath) {
        return new WebDriverWait(Browser.initDriver(), Browser.SHORT_TIMEOUT_SECONDS).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(locatorPath))).isDisplayed();
    }

    public static WebElement waitForElementLocated(String locatorPath) {
        wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorPath)));
    }

    public static List<WebElement> waitForAllElementsLocated(String locatorPath) {
        wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorPath)));
    }

    public static WebElement waitForElementToBeClickable(String locatorPath) {
        wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorPath)));
    }

    public static void waitForInvisibilityOfElementLocated(String locatorPath, int timeoutSeconds) {
        new WebDriverWait(Browser.initDriver(), timeoutSeconds).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorPath)));
    }
}
