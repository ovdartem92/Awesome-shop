package service;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface ActionManager {

    static WebElement getElementBy(String locatorPath) {
        return Browser.getDriver().findElement(By.xpath(locatorPath));
    }

    static void clickOnElementBy(String locatorPath) {
        if (WaitManager.isElementVisibleBy(locatorPath))
            getElementBy(locatorPath).click();
    }

    static String getTextOnElementBy(String locatorPath) {
        return WaitManager.isElementVisibleBy(locatorPath) ? getElementBy(locatorPath).getText() : null;
    }

    static String getAttributeValueOnElementBy(String locatorPath, String attribute) {
        return WaitManager.isElementVisibleBy(locatorPath) ? getElementBy(locatorPath).getAttribute(attribute) : null;
    }

    static void typeTextToElementBy(String locatorPath, String text) {
        if (WaitManager.isElementVisibleBy(locatorPath)) {
            WebElement element = getElementBy(locatorPath);
            element.clear();
            element.sendKeys(text);
        }
    }


}
