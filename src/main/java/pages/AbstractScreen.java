package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.net.skyscanner.elements.CaptchaScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.WaitManager;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractScreen {
    protected static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    protected static final Logger logger = LogManager.getRootLogger();
    public static final HeaderScreen HEADER_SCREEN = new HeaderScreen();

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

    public static void typeTextToElement(String locatorPath, String text) {
        WebElement element = getElement(locatorPath);
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
        logger.info("Type text {} to element with next xpath: {}", text, locatorPath);
    }

    public static List<String> getTextFromElements(String locatorPath) {
        List<String> textFromElements = new ArrayList<>();
        for (WebElement element : getElements(locatorPath)) {
            textFromElements.add(element.getText());
        }
        return textFromElements;
    }
}
