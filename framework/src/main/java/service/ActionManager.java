package service;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface ActionManager {

    static WebElement getElementBy(By locator) {
        return Browser.getDriver().findElement(locator);
    }

    static void clickOnElementBy(By locator) {
        if (WaitManager.isElementVisibleBy(locator))
            getElementBy(locator).click();
    }

    static String getTextOnElementBy(By locator) {
        return WaitManager.isElementVisibleBy(locator) ? getElementBy(locator).getText() : null;
    }

    static String getAttributeValueOnElementBy(By locator, String attribute) {
        return WaitManager.isElementVisibleBy(locator) ? getElementBy(locator).getAttribute(attribute) : null;
    }

    static void typeTextToElementBy(By locator, String text) {
        if (WaitManager.isElementVisibleBy(locator)) {
            WebElement element = getElementBy(locator);
            element.clear();
            element.sendKeys(text);
        }
    }
}
