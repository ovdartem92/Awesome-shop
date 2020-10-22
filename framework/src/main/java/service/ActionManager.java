package service;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public interface ActionManager {

    static WebElement getElementBy(String locatorPath) {
        return Browser.getDriver().findElement(By.xpath(locatorPath));
    }

    static List<WebElement> getElementsBy(String locatorPath) {
        return Browser.getDriver().findElements(By.xpath(locatorPath));
    }

    static void clickOnElementBy(String locatorPath) {
        if (WaitManager.isElementVisibleBy(locatorPath))
            getElementBy(locatorPath).click();
    }

    static String getTextOnElementBy(String locatorPath) {
        if(!WaitManager.isElementVisibleBy(locatorPath))
            throw new NoSuchElementException(String.format("There is no element with a locator %s on the page.", locatorPath));
        return getElementBy(locatorPath).getText();
    }

    static String getAttributeValueOnElementBy(String locatorPath, String attribute) {
        if(!WaitManager.isElementVisibleBy(locatorPath))
            throw new NoSuchElementException(String.format("There is no element with a locator %s on the page.", locatorPath));
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
        for (Keys key : keys) {
            if (WaitManager.isElementVisibleBy(locatorPath)) {
                WebElement element = getElementBy(locatorPath);
                element.sendKeys(key);
            }
        }
    }
}
