package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.net.skyscanner.elements.CaptchaScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.WaitManager;

import java.util.List;

public abstract class AbstractScreen {
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    protected static Logger logger = LogManager.getRootLogger();
    public static HeaderScreen header = new HeaderScreen();

    public static WebElement getElement(String locatorPath) {
        CaptchaScreen.checkCaptchaOnPage();
        return WaitManager.waitForElementLocated(locatorPath);
    }

    public static List<WebElement> getElements(String locatorPath) {
        CaptchaScreen.checkCaptchaOnPage();
        return WaitManager.waitForAllElementsLocated(locatorPath);
    }

    public static void clickOnElement(String locatorPath) {
        CaptchaScreen.checkCaptchaOnPage();
        WaitManager.waitForElementToBeClickable(locatorPath).click();
        logger.info("Click on element with next xpath: {}", locatorPath);
    }

    public static String getTextOnElement(String locatorPath) {
        return WaitManager.waitForElementLocated(locatorPath).getText();
    }

    public static String getAttributeValueOnElement(String locatorPath, String attribute) {
        return WaitManager.waitForElementLocated(locatorPath).getAttribute(attribute);
    }

    public static void typeTextToElement(String locatorPath, String text) {
        WebElement element = getElement(locatorPath);
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
        logger.info("Type text {} to element with next xpath: {}", text, locatorPath);
    }
}
