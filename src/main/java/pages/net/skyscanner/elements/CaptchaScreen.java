package pages.net.skyscanner.elements;

import driver.Browser;
import org.testng.SkipException;
import pages.AbstractScreen;
import service.WaitManager;

/**
 * The class contains elements and methods for working with the captcha screen.
 */
public class CaptchaScreen extends AbstractScreen {
    private static final String CAPTCHA_ELEMENT_LOCATOR = "//img[@alt='captcha page image']";

    /**
     * The method for finding captcha on the page, if a captcha was found on the page, an exception will be thrown.
     *
     * @throws SkipException if captcha was found on the page
     */
    public static void checkCaptchaOnPage() {
        if (WaitManager.isElementVisible(CAPTCHA_ELEMENT_LOCATOR, Browser.SHORT_TIMEOUT_SECONDS)) {
            logger.error("Test was skipped, because CAPTCHA has appeared");
            throw new SkipException("Captcha has appeared on this page");
        }
    }
}
