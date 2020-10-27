package utils;

import driver.Browser;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import static driver.Browser.SHORT_TIMEOUT_SECONDS;

public interface CaptchaMethod {
    By CAPTCHA_ELEMENT_LOCATOR = By.xpath("//*[contains(text(), 'Are you a person or a robot?')]");

    static boolean checkCaptchaOnPage(Logger logger) {
        if (new WebDriverWait(Browser.getDriver(), SHORT_TIMEOUT_SECONDS).until(
                ExpectedConditions.presenceOfElementLocated(CAPTCHA_ELEMENT_LOCATOR)).isDisplayed()) {
            logger.info(String.format("Captcha element is present on pages.page: [ %s ]", Browser.getDriver().getCurrentUrl()));
            throw new SkipException("Test was skipped, because CAPTCHA has appeared");
        }
        return false;
    }
}
