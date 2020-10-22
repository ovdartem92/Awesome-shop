package util;

import driver.Browser;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

public interface CaptchaMethod {
    By CAPTCHA_ELEMENT_LOCATOR = By.xpath("//*[contains(text(), 'Are you a person or a robot?')]");

    static void checkCaptchaOnPage(Logger logger) {
        if (new WebDriverWait(Browser.getDriver(), 4).until(
                ExpectedConditions.presenceOfElementLocated(CAPTCHA_ELEMENT_LOCATOR)).isDisplayed()) {
            logger.info(String.format("Captcha element is present on page: [ %s ]", Browser.getDriver().getCurrentUrl()));
            throw new SkipException("Test was skipped, because CAPTCHA has appeared");
        }
    }
}
