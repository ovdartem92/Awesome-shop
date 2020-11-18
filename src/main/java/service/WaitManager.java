package service;

import driver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public abstract class WaitManager {
    private static final long PULLING_EVERY_MILLIS_SECONDS = 300;
    private static Wait<WebDriver> wait;

    private WaitManager() {
    }

    public static Wait<WebDriver> getDefaultWaitConfig() {
        return getCustomWaitConfig(Browser.DEFAULT_TIMEOUT_SECONDS, PULLING_EVERY_MILLIS_SECONDS);
    }

    public static Wait<WebDriver> getCustomWaitConfig(long timeout, long pooling) {
        return new FluentWait<>(Browser.initDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pooling))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public static boolean isElementVisible(String locatorPath, long timeout) {
        wait = getCustomWaitConfig(timeout, PULLING_EVERY_MILLIS_SECONDS);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
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
}
