package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import pages.net.skyscanner.elements.Captcha;
import pages.net.skyscanner.elements.HeaderScreen;
import service.CultureService;
import service.WaitManager;

import java.util.List;

public abstract class AbstractScreen {
    public static Logger logger = LogManager.getRootLogger();
    private static HeaderScreen header = new HeaderScreen();
    public static CultureService cultureService = new CultureService(header);

    public static WebElement getElement(String locatorPath) {
        Captcha.checkCaptchaOnPage();
        return WaitManager.waitForElementLocated(locatorPath);
    }

    public static List<WebElement> getElements(String locatorPath) {
        Captcha.checkCaptchaOnPage();
        return WaitManager.waitForAllElementsLocated(locatorPath);
    }

    public static void clickOnElement(String locatorPath) {
        Captcha.checkCaptchaOnPage();
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
        element.clear();
        element.sendKeys(text);
        logger.info("Type text {} to element with next xpath: {}", text, locatorPath);
    }

    public static void changeLanguage(String language) {
        cultureService.changeLanguage(language);
    }

    public static void changeCurrency(String currency) {
        cultureService.changeCurrency(currency);
    }
}
