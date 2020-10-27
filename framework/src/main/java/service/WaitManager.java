package service;

import driver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static driver.Browser.DEFAULT_TIMEOUT_SECONDS;
import static driver.Browser.SHORT_TIMEOUT_SECONDS;

public interface WaitManager {

    static Wait<WebDriver> getDefaultWaitConfig() {
        return new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(SHORT_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    static boolean isElementVisibleBy(String locatorPath) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    static void waitForElementLocatedBy(String locatorPath) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
    }

    static void waitForAllElementsLocatedBy(String locatorPath) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorPath)));
    }
}
