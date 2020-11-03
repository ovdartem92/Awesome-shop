package pages;

import driver.Browser;
import org.testng.SkipException;
import service.WaitManager;

public abstract class Captcha extends AbstractPage {
    private static final String CAPTCHA_ELEMENT_LOCATOR = "//img[contains(@class,'BpkImage')]";

    public static void checkCaptchaOnPage() {
        if (WaitManager.isElementVisible(CAPTCHA_ELEMENT_LOCATOR, Browser.SHORT_TIMEOUT_SECONDS)) {
            logger.error("Test was skipped, because CAPTCHA has appeared");
            throw new SkipException("Captcha has appeared on this page");
        }
    }
}
