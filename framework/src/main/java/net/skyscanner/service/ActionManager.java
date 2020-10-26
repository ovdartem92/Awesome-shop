package net.skyscanner.service;

import net.skyscanner.driver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static net.skyscanner.util.CaptchaMethod.checkCaptchaOnPage;

public interface ActionManager {
    Logger logger = LogManager.getRootLogger();

    static WebElement getElementBy(String locatorPath) {
        if (!WaitManager.isElementVisibleBy(locatorPath)) {
            if (!checkCaptchaOnPage(logger))
                throw new NoSuchElementException(String.format("There is no element with a locator %s on the page.", locatorPath));
        }
        return Browser.getDriver().findElement(By.xpath(locatorPath));
    }

    static List<WebElement> getElementsBy(String locatorPath) {
        if (!WaitManager.isElementVisibleBy(locatorPath)) {
            if (!checkCaptchaOnPage(logger))
                throw new NoSuchElementException(String.format("There are no elements with a locator %s on the page.", locatorPath));
        }
        return Browser.getDriver().findElements(By.xpath(locatorPath));
    }


    static void clickOnElementBy(String locatorPath) {
        WaitManager.waitForElementToBeClickableBy(locatorPath).click();
        checkCaptchaOnPage(logger);
        logger.info("Click on element with next xpath: ["+locatorPath+"]");
    }

    static String getTextOnElementBy(String locatorPath) {
        return WaitManager.waitForElementLocatedBy(locatorPath).getText();
    }

    static String getAttributeValueOnElementBy(String locatorPath, String attribute) {
        return WaitManager.waitForElementLocatedBy(locatorPath).getAttribute(attribute);
    }

    static void typeTextToElementBy(String locatorPath, String text) {
        if (WaitManager.isElementVisibleBy(locatorPath)) {
            WebElement element = getElementBy(locatorPath);
            element.clear();
            element.sendKeys(text);
        }
        logger.info("Type text ["+text+"] to element with next xpath: ["+locatorPath+"]");
    }

    static void typeKeysToElementBy(String locatorPath, Keys... keys) {
        if (WaitManager.isElementVisibleBy(locatorPath)) {
            for (Keys key : keys) {
                WebElement element = getElementBy(locatorPath);
                element.sendKeys(key);
            }
        }
        logger.info("Type keys ["+keys+"] to element with next xpath: ["+locatorPath+"]");
    }

    static void typeInFieldWithDelay(String locatorPath, String text) {
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
        logger.info("Type text with delay ["+text+"] to element with next xpath: ["+locatorPath+"]");
    }

}
