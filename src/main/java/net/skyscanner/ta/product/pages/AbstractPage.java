package net.skyscanner.ta.product.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.net.skyscanner.elements.CaptchaScreen;
import service.WaitManager;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is a super class for all pages.
 * The class contains general methods for interacting with web elements .
 */
public abstract class AbstractPage {
    /**
     * This variable is xpath locator of web element, which appears when we fill in the search field.
     * It's first element of drop-down list, and this element contains needed value for input field.
     * It's common locator for all search pages.
     */
    protected static final String FIRST_DROP_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    protected static final Logger logger = LogManager.getRootLogger();

    /**
     * The private protected is needed because we can be called by subclasses or by classes in the same package.
     */
    protected AbstractPage() {
    }

    /**
     * This method performs getting of needed web element.
     *
     * @param locatorPath the param according to witch we get web element.
     */
    public static WebElement getElement(String locatorPath) {
        CaptchaScreen.checkCaptchaOnPage();
        return WaitManager.waitForElementLocated(locatorPath);
    }

    /**
     * This method performs getting attribute value of needed web element.
     *
     * @param locatorPath the param according to witch we get web element.
     * @param attribute   the value of needed attribute.
     * @return attribute's text.
     */
    public static String getAttributeValueOnElement(String locatorPath, String attribute) {
        return WaitManager.waitForElementLocated(locatorPath).getAttribute(attribute);
    }

    /**
     * This method performs getting of needed web elements list.
     *
     * @param locatorPath the param according to witch we get web elements.
     */
    public static List<WebElement> getElements(String locatorPath) {
        CaptchaScreen.checkCaptchaOnPage();
        return WaitManager.waitForAllElementsLocated(locatorPath);
    }

    /**
     * This method performs getting of needed web element, checks that element is clickable and click on it.
     *
     * @param locatorPath the param according to witch we get web element.
     */
    public static void clickOnElement(String locatorPath) {
        CaptchaScreen.checkCaptchaOnPage();
        WaitManager.waitForElementToBeClickable(locatorPath).click();
        logger.info("Click on element with next xpath: {}", locatorPath);
    }

    /**
     * This method performs getting text value of needed web element.
     *
     * @param locatorPath the param according to witch we get web element.
     */
    public static String getTextOnElement(String locatorPath) {
        return WaitManager.waitForElementLocated(locatorPath).getText();
    }

    /**
     * This method performs typing text to needed web element, previously clears input field.
     *
     * @param locatorPath the param according to witch we get web element.
     */
    public static void typeTextToElement(String locatorPath, String text) {
        WebElement element = getElement(locatorPath);
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
        logger.info("Type text {} to element with next xpath: {}", text, locatorPath);
    }

    /**
     * This method performs getting text value of needed web elements list.
     *
     * @param locatorPath the param according to witch we get web elements.
     * @return the list of strings, each string contains text from web elements.
     */
    public static List<String> getTextFromElements(String locatorPath) {
        List<String> textFromElements = new ArrayList<>();
        for (WebElement element : getElements(locatorPath)) {
            textFromElements.add(element.getText());
        }
        return textFromElements;
    }
}
