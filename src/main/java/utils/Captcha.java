package utils;

import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import service.WaitManager;

public final class Captcha {
    static String CAPTCHA_ELEMENT_PATH = "//*[contains(text(), 'Are you a person or a robot?')]";

    public static boolean checkCaptchaOnPage(Logger logger) {
        if (WaitManager.isElementDisplayed(CAPTCHA_ELEMENT_PATH)) {
            logger.info("Click on element with next xpath: {}", CAPTCHA_ELEMENT_PATH);
            throw new SkipException("Test was skipped, because CAPTCHA has appeared");
        }
        return false;
    }
}
