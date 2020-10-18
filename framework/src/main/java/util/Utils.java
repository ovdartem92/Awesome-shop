package util;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Utils {

    static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 500)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    static void checkCaptchaOnPage(WebDriver driver, Logger logger, By by) {
        boolean answer = new WebDriverWait(driver, 4).until(
                ExpectedConditions.presenceOfElementLocated(by)).isDisplayed();
        if (answer) {
            logger.info("Is CAPTCHA element present on page: [" + driver.getCurrentUrl() + "]");
            throw new RuntimeException("The page consists captcha element.");
        }
    }
}
