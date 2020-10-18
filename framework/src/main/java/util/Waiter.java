package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public interface Waiter {

    static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 500)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    static List<WebElement> waitForAllElementsLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 500)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
