package util;

import driver.Browser;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface CaptchaMethod {

    By CAPTCHA_ELEMENT_LOCATOR = By.xpath("//*[contains(text(), 'Are you a person or a robot?')]");

    static boolean checkCaptchaOnPage(Logger logger) {
        boolean answer = new WebDriverWait(Browser.getDriver(), 4).until(
                ExpectedConditions.presenceOfElementLocated(CAPTCHA_ELEMENT_LOCATOR)).isDisplayed();
        if (answer) {
            logger.info("Captcha element is present on page: [" + Browser.getDriver().getCurrentUrl() + "]");
            throw new RuntimeException("The page consists captcha element.");
        }
        return answer;
    }
}
