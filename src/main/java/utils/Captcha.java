package utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.SkipException;
import service.WaitManager;

public final class Captcha {
    static String CAPTCHA_ELEMENT_PATH = "//img[contains(@class,'BpkImage')]";

    public static void checkCaptchaOnPage(Logger logger) {
        try {
            if (WaitManager.isCaptchaDisplayed(CAPTCHA_ELEMENT_PATH))
                throw new SkipException("Captcha has appeared on this page");
        } catch (NoSuchElementException | TimeoutException e) {
            logger.info(e.getMessage());
        }
    }
}
