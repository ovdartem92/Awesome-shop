package service;

import driver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public abstract class WaitManager {

    public static Wait<WebDriver> getDefaultWaitConfig() {
        return new FluentWait<>(Browser.initDriver())
                .withTimeout(Duration.ofSeconds(Browser.DEFAULT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(Browser.SHORT_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public static boolean isElementVisibleBy(String locatorPath) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static WebElement waitForElementLocatedBy(String locatorPath) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorPath)));
    }

    public static List<WebElement> waitForAllElementsLocatedBy(String locatorPath) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorPath)));
    }

    public static WebElement waitForElementToBeClickableBy(String locatorPath) {
        Wait<WebDriver> wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorPath)));
    }
}
