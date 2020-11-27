package service;

import driver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * The class performs waiting web elements with different conditions, returns web element or elements after waiting,
 * checks visibility of element, gives customizable configuration for WebDriverWait object.
 */
public class WaitManager {
    private static final long PULLING_EVERY_MILLIS_SECONDS = 300;
    private static Wait<WebDriver> wait;

    /**
     * The private constructor is needed because we don't create any instance of this class.
     */
    private WaitManager() {
    }

    /**
     * This method performs default FluentWait,
     * uses default timeout value from Browser class for timeout param and pulling timeout from this class for pulling param.
     */
    public static Wait<WebDriver> getDefaultWaitConfig() {
        return getCustomWaitConfig(Browser.DEFAULT_TIMEOUT_SECONDS, PULLING_EVERY_MILLIS_SECONDS);
    }

    /**
     * This method provides the customize FluentWait that may have its timeout
     * and polling interval configured on the fly.
     *
     * @param timeout the number of seconds for waiting an element to be present on the page.
     * @param pooling the interval in milliseconds witch using for checking for element to be present.
     * @ignore NoSuchElementException, StaleElementReferenceException - specific types of exception waiting
     * while searching for an element on the page.
     */
    public static Wait<WebDriver> getCustomWaitConfig(long timeout, long pooling) {
        return new FluentWait<>(Browser.initDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pooling))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    /**
     * This method performs checking that an element is present on the DOM of a page and visible.
     *
     * @param locatorPath the xpath of required web element.
     * @param timeout     the number of seconds for waiting an element to be present on the page.
     * @return boolean value.
     * @catch TimeoutException cause we using custom wait config.
     */
    public static boolean isElementVisible(String locatorPath, long timeout) {
        wait = getCustomWaitConfig(timeout, PULLING_EVERY_MILLIS_SECONDS);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * This method performs an expectation for checking that an element is present on the DOM of a page,
     * uses default wait config.
     *
     * @param locatorPath the xpath of required web element.
     * @return web element.
     */
    public static WebElement waitForElementLocated(String locatorPath) {
        wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorPath)));
    }

    /**
     * This method performs an expectation for checking that there is at least one element present on a web page,
     * uses default wait config.
     *
     * @param locatorPath the xpath of required web element.
     * @return list of web elements.
     */
    public static List<WebElement> waitForAllElementsLocated(String locatorPath) {
        wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorPath)));
    }

    /**
     * This method performs an expectation for checking an element is visible and enabled such that you can click it,
     * uses default wait config.
     *
     * @param locatorPath the xpath of required web element.
     * @return web element.
     */
    public static WebElement waitForElementToBeClickable(String locatorPath) {
        wait = getDefaultWaitConfig();
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorPath)));
    }

    public static boolean waitForInvisibilityOfElementLocated(String locatorPath, int timeoutSeconds) {
        return new WebDriverWait(Browser.getDriver(), timeoutSeconds)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorPath)));
    }
}
