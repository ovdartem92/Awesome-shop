package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import pages.net.skyscanner.elements.Captcha;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.profilePage.ProfilePage;
import service.CultureService;
import service.WaitManager;

import java.util.List;

public abstract class AbstractScreen {
    public static final Logger LOGGER = LogManager.getRootLogger();

    public static final HeaderScreen HEADER_SCREEN = new HeaderScreen();
    public static final CultureService CULTURE_SERVICE = new CultureService();
    public static final ProfilePage PROFILE_PAGE = new ProfilePage();

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
        LOGGER.info("Click on element with next xpath: {}", locatorPath);
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
        LOGGER.info("Type text {} to element with next xpath: {}", text, locatorPath);
    }

    public static void typeInFieldWithDelay(String locatorPath, String text) {
        WebElement element = getElement(locatorPath);
        String[] letters = text.split("");

        for (String letter : letters) {
            try {
                element.sendKeys(letter);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("Type text with delay {} to element with next xpath: {}", text, locatorPath);
    }
}
