package utils;

import driver.Browser;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;

import static service.WaitManager.isElementDisplayed;

public final class Captcha {
    private static final String CAPTCHA_ELEMENT_LOCATOR = "//img[contains(@class,'BpkImage')]";

    public static boolean checkCaptchaOnPage(Logger logger) {
        if (isElementDisplayed(CAPTCHA_ELEMENT_LOCATOR)) {
            logger.info("Captcha element is present on pages.page: {}", Browser.initDriver().getCurrentUrl());
            throw new SkipException("Test was skipped, because CAPTCHA has appeared");
        }
        return false;
    }
}
