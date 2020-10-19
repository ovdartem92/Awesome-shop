package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public interface CaptchaMethod {
    final By CAPTCHA_ELEMENT = By.xpath("//*[contains(text(), 'Are you a person or a robot?')]");

    static boolean checkCaptchaOnPage(WebDriver driver) {
        return new WebDriverWait(driver, 4).until(
                ExpectedConditions.presenceOfElementLocated(CAPTCHA_ELEMENT)).isDisplayed();
    }
}
