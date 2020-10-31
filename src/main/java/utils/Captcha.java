package utils;

import driver.Browser;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import service.WaitManager;

public abstract class Captcha {
    final static String CAPTCHA_ELEMENT_LOCATOR = "//img[contains(@class,'BpkImage')]";

    public static void checkCaptchaOnPage(Logger logger) {
        if (WaitManager.isElementVisible(Browser.SHORT_TIMEOUT_SECONDS, CAPTCHA_ELEMENT_LOCATOR))
            logger.info("Test was skipped, because CAPTCHA has appeared");
            throw new SkipException("Captcha has appeared on this page");
    }
}
