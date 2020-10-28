package pages;

import driver.Browser;
import service.WaitManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import utils.CaptchaMethod;

import java.util.List;


public abstract class AbstractPage {
    protected static final String WAITING_MODAL_VIEW = "//*[@class='WaitingModal_WaitingModal__container__2wluW']";
    public static Logger logger = LogManager.getRootLogger();

    public void isWaitingModalViewOnPage() {
        WaitManager.waitForInvisibilityOfElementLocated(WAITING_MODAL_VIEW, Browser.LONG_TIMEOUT_SECONDS);
    }

    public static WebElement getElementBy(String locatorPath) {
        CaptchaMethod.checkCaptchaOnPage(logger);
        return WaitManager.waitForElementLocatedBy(locatorPath);
    }

    public static List<WebElement> getElementsBy(String locatorPath) {
        CaptchaMethod.checkCaptchaOnPage(logger);
        return WaitManager.waitForAllElementsLocatedBy(locatorPath);
    }

    public static void clickOnElementBy(String locatorPath) {
        CaptchaMethod.checkCaptchaOnPage(logger);
        WaitManager.waitForElementToBeClickableBy(locatorPath).click();
        logger.info("Click on element with next xpath: {}", locatorPath);
    }

    public static String getTextOnElementBy(String locatorPath) {
        return WaitManager.waitForElementLocatedBy(locatorPath).getText();
    }

    public static String getAttributeValueOnElementBy(String locatorPath, String attribute) {
        return WaitManager.waitForElementLocatedBy(locatorPath).getAttribute(attribute);
    }

    public static void typeTextToElementBy(String locatorPath, String text) {
        WebElement element = getElementBy(locatorPath);
        element.clear();
        element.sendKeys(text);
        logger.info("Type text {} to element with next xpath: {}", text, locatorPath);
    }

    public static void typeInFieldWithDelay(String locatorPath, String text) {
        WebElement element = getElementBy(locatorPath);
        String[] letters = text.split("");

        for (String letter : letters) {
            try {
                element.sendKeys(letter);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("Type text with delay {} to element with next xpath: {}", text, locatorPath);
    }
}
