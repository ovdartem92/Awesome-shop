package net.skyscanner.ta.product.pages;

import driver.Browser;
import org.testng.SkipException;
import pages.AbstractScreen;
import service.WaitManager;

public class CaptchaPage extends AbstractScreen {
    private static final String CAPTCHA_ELEMENT_LOCATOR = "//img[@alt='captcha page image']";

    public static void checkCaptchaOnPage() {
        if (WaitManager.isElementVisible(CAPTCHA_ELEMENT_LOCATOR, Browser.SHORT_TIMEOUT_SECONDS)) {
            logger.error("Test was skipped, because CAPTCHA has appeared");
            throw new SkipException("Captcha has appeared on this page");
        }
    }
}
