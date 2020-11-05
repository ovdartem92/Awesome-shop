package pages.net.skyscanner.elements;

import model.User;
import pages.AbstractScreen;
import service.LogInService;
import service.WaitManager;

public class LogInScreen extends AbstractScreen {
    private static final String CONTINUE_WITH_EMAIL_BUTTON_LOCATOR = "//button[@data-testid='login-email-button']";
    private static final String ACCOUNT_DETECTED_BUTTON_LOCATOR = "//button[@data-testid='account-detection-button']";
    private static final String LOG_IN_BUTTON_LOCATOR = "//button[@data-testid='login-button']";
    private static final String CLOSE_MODAL_LOGIN_WINDOW_BUTTON_LOCATOR = "//button[@title='Close modal']";
    private static final String EMAIL_FIELD_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_FIELD_LOCATOR = "//input[@id='password']";
    private static final String WRONG_EMAIL_OR_PASSWORD_FIELD_LOCATOR = "//span[text()='Wrong email or password']";
    private static final String MARKETING_CONSENT_BUTTON_LOCATOR = "//button[@data-testid='btn-marketing-consent-cta']";

    public static String getEmailFieldLocator() {
        return EMAIL_FIELD_LOCATOR;
    }

    public static String getPasswordFieldLocator() {
        return PASSWORD_FIELD_LOCATOR;
    }

    public LogInScreen clickToContinueWithEmail() {
        clickOnElement(CONTINUE_WITH_EMAIL_BUTTON_LOCATOR);
        return this;
    }

    public void clickToNextButton() {
        clickOnElement(ACCOUNT_DETECTED_BUTTON_LOCATOR);
    }

    public void clickToLogInButton() {
        clickOnElement(LOG_IN_BUTTON_LOCATOR);
    }

    public void clickToCloseModal() {
        clickOnElement(CLOSE_MODAL_LOGIN_WINDOW_BUTTON_LOCATOR);
    }

    public boolean isWrongEmailOrPasswordMessageDisplayed() {
        return WaitManager.isElementVisible(WRONG_EMAIL_OR_PASSWORD_FIELD_LOCATOR);
    }

    public void marketingConsentButtonAvailable() {
        WaitManager.waitForElementLocated(MARKETING_CONSENT_BUTTON_LOCATOR);
    }

    public HeaderScreen logIn(User user) {
        LogInService.LogIn(user);
        return new HeaderScreen();
    }
}
