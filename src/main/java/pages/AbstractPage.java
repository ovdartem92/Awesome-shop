package pages;

import driver.Browser;
import service.TestDataReader;
import service.WaitManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static driver.Browser.LONG_TIMEOUT_SECONDS;
import static service.WaitManager.waitForAllElementsLocatedBy;
import static service.WaitManager.waitForElementLocatedBy;
import static utils.CaptchaMethod.checkCaptchaOnPage;

public abstract class AbstractPage {
    public static final String CULTURE_SAVE_BUTTON_PATH = "//button[@id='culture-selector-save']";
    protected static final String WAITING_MODAL_VIEW = "//*[@class='WaitingModal_WaitingModal__container__2wluW']";
    public static Logger logger = LogManager.getRootLogger();

    public void isWaitingModalViewOnPage() {
        new WebDriverWait(Browser.getDriver(), LONG_TIMEOUT_SECONDS).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath(WAITING_MODAL_VIEW)));
    }

    public static String getHomepageUrl() {
        return TestDataReader.getTestData("testData.home.url");
    }

    public static WebElement getElementBy(String locatorPath) {
        checkCaptchaOnPage(logger);
        return waitForElementLocatedBy(locatorPath);
    }

    public static List<WebElement> getElementsBy(String locatorPath) {
        checkCaptchaOnPage(logger);
        return waitForAllElementsLocatedBy(locatorPath);
    }

    public static void clickOnElementBy(String locatorPath) {
        checkCaptchaOnPage(logger);
        WaitManager.waitForElementToBeClickableBy(locatorPath).click();
        logger.info(String.format("Click on element with next xpath: [%s]", locatorPath));
    }

    public static String getTextOnElementBy(String locatorPath) {
        return waitForElementLocatedBy(locatorPath).getText();
    }

    public static String getAttributeValueOnElementBy(String locatorPath, String attribute) {
        return waitForElementLocatedBy(locatorPath).getAttribute(attribute);
    }

    public static void typeTextToElementBy(String locatorPath, String text) {
        if (WaitManager.isElementVisibleBy(locatorPath)) {
            WebElement element = getElementBy(locatorPath);
            element.clear();
            element.sendKeys(text);
        }
        logger.info(String.format("Type text [%s] to element with next xpath: [%s]", text, locatorPath));
    }

    public static void typeKeysToElementBy(String locatorPath, Keys... keys) {
        if (WaitManager.isElementVisibleBy(locatorPath)) {
            for (Keys key : keys) {
                WebElement element = getElementBy(locatorPath);
                element.sendKeys(key);
            }
        }
        logger.info(String.format("Type keys [%s] to element with next xpath [%s]", keys, locatorPath));
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
        logger.info(String.format("Type text with delay [%s] to element with next xpath: [%s]", text, locatorPath));
    }
}
