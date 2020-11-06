package pages.net.skyscanner.elements;

import model.User;
import pages.AbstractScreen;
import service.AccountService;
import service.WaitManager;

public class LogInScreen extends AbstractScreen {
    private static final String CONTINUE_WITH_EMAIL_BUTTON_LOCATOR = "//button[@data-testid='login-email-button']";
    private static final String ACCOUNT_DETECTED_BUTTON_LOCATOR = "//button[@data-testid='account-detection-button']";
    private static final String LOG_IN_BUTTON_LOCATOR = "//button[@data-testid='login-button']";
    private static final String CLOSE_MODAL_LOGIN_WINDOW_BUTTON_LOCATOR = "//button[@title='Close modal']";
    private static final String MARKETING_CONSENT_BUTTON_LOCATOR = "//button[@data-testid='btn-marketing-consent-cta']";

    public LogInScreen clickContinueWithEmailButton() {
        clickOnElement(CONTINUE_WITH_EMAIL_BUTTON_LOCATOR);
        return this;
    }

    public LogInScreen clickNextButton() {
        clickOnElement(ACCOUNT_DETECTED_BUTTON_LOCATOR);
        return this;
    }

    public LogInScreen clickLogInButton() {
        clickOnElement(LOG_IN_BUTTON_LOCATOR);
        return this;
    }

    public HeaderScreen logIn(User user) {
        new AccountService().logIn(user);
        return new HeaderScreen();
    }

    public HeaderScreen clickCloseModalButton() {
        clickOnElement(CLOSE_MODAL_LOGIN_WINDOW_BUTTON_LOCATOR);
        return new HeaderScreen();
    }

    public void waitMarketingConsentButtonAvailable() {
        WaitManager.isElementVisible(MARKETING_CONSENT_BUTTON_LOCATOR,2);
    }
}
