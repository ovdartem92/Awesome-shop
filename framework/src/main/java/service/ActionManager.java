package service;

import driver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static util.CaptchaMethod.checkCaptchaOnPage;

public interface ActionManager {
    Logger logger = LogManager.getRootLogger();

    static WebElement getElementBy(String locatorPath) {
        checkCaptchaOnPage(logger);
        if (!WaitManager.isElementVisibleBy(locatorPath))
            throw new NoSuchElementException(String.format("There is no element with a locator %s on the page.", locatorPath));
        return Browser.getDriver().findElement(By.xpath(locatorPath));
    }

    static List<WebElement> getElementsBy(String locatorPath) {
        if (!WaitManager.isElementVisibleBy(locatorPath))
            throw new NoSuchElementException(String.format("There is no element with a locator %s on the page.", locatorPath));
        return Browser.getDriver().findElements(By.xpath(locatorPath));
    }

    static void clickOnElementBy(String locatorPath) {
        if (WaitManager.isElementVisibleBy(locatorPath))
            getElementBy(locatorPath).click();
    }

    static String getTextOnElementBy(String locatorPath) {
        return getElementBy(locatorPath).getText();
    }

    static String getAttributeValueOnElementBy(String locatorPath, String attribute) {
        return getElementBy(locatorPath).getAttribute(attribute);
    }

    static void typeTextToElementBy(String locatorPath, String text) {
        if (WaitManager.isElementVisibleBy(locatorPath)) {
            WebElement element = getElementBy(locatorPath);
            element.clear();
            element.sendKeys(text);
        }
    }

    static void typeKeysToElementBy(String locatorPath, Keys... keys) {
        if (WaitManager.isElementVisibleBy(locatorPath)) {
            for (Keys key : keys) {
                WebElement element = getElementBy(locatorPath);
                element.sendKeys(key);
            }
        }
    }

    static void typeInFieldWithDelay(String xpath, String value){
        WebElement element = getElementBy(xpath);
        String[] letters = value.split("");

        for (String letter : letters) {
            try {
                element.sendKeys(letter);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
