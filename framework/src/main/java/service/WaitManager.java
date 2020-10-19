package service;

import constants.Timeout;
import driver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public interface WaitManager {

    static Wait<WebDriver> getDefaultWaitConfig() {
        return new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(Timeout.DEFAULT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofMillis(Timeout.SHORT_TIMEOUT_MILLIS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    static boolean isElementVisibleBy(By locator) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    static void waitForElementLocatedBy(By locator) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
