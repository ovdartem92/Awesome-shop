package pages;

import driver.Browser;
import service.WaitManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.Captcha.checkCaptchaOnPage;

public abstract class AbstractPage {
    protected static final String WAITING_MODAL_VIEW = "//*[@class='WaitingModal_WaitingModal__container__2wluW']";
    public static Logger logger = LogManager.getRootLogger();

    public void isWaitingModalViewOnPage() {
        WaitManager.waitForInvisibilityOfElementLocated(WAITING_MODAL_VIEW, Browser.LONG_TIMEOUT_SECONDS);
    }

    public static WebElement getElement(String locatorPath) {
        checkCaptchaOnPage(logger);
        return WaitManager.waitForElementLocated(locatorPath);
    }

    public static List<WebElement> getElements(String locatorPath) {
        checkCaptchaOnPage(logger);
        return WaitManager.waitForAllElementsLocated(locatorPath);
    }

    public static void clickOnElement(String locatorPath) {
        checkCaptchaOnPage(logger);
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
        logger.info("Type text with delay {} to element with next xpath: {}", text, locatorPath);
    }
}
