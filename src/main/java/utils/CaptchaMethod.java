package utils;

import driver.Browser;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;


public final class CaptchaMethod {
    private static final String CAPTCHA_ELEMENT_LOCATOR = "//img[contains(@class,'BpkImage')]";

    public static boolean checkCaptchaOnPage(Logger logger) {
        if (new WebDriverWait(Browser.initDriver(), Browser.SHORT_TIMEOUT_SECONDS).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(CAPTCHA_ELEMENT_LOCATOR))).isDisplayed()) {
            logger.info("Captcha element is present on pages.page: {}", Browser.initDriver().getCurrentUrl());
            throw new SkipException("Test was skipped, because CAPTCHA has appeared");
        }
        return false;
    }
}
