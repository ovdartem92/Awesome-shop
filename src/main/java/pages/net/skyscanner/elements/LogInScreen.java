package pages.net.skyscanner.elements;

import driver.Browser;
import pages.AbstractScreen;
import service.WaitManager;

public class LogInScreen extends AbstractScreen {
    private static final String CONTINUE_WITH_EMAIL_BUTTON_LOCATOR = "//button[@data-testid='login-email-button']";
    private static final String ACCOUNT_DETECTED_BUTTON_LOCATOR = "//button[@data-testid='account-detection-button']";
    private static final String LOG_IN_BUTTON_LOCATOR = "//button[@data-testid='login-button']";
    private static final String WRONG_EMAIL_MESSAGE_LOCATOR = "//span[contains(@class,'banner-alert__icon')]";
    private static final String EMAIL_FIELD_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_FIELD_LOCATOR = "//input[@id='password']";
    private static final String CLOSE_MODAL_LOCATOR = "//button[@data-testid='modal-close-button']";

    public LogInScreen typeTextToEmailField(String txt) {
        typeTextToElement(EMAIL_FIELD_LOCATOR, txt);
        return this;
    }

    public LogInScreen typeTextToPasswordField(String txt) {
        typeTextToElement(PASSWORD_FIELD_LOCATOR, txt);
        return this;
    }

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

    public LogInScreen clickCloseModalButton() {
        clickOnElement(CLOSE_MODAL_LOCATOR);
        return this;
    }

    public Boolean isWrongEmailMessageDisplayed() {
        return WaitManager.isElementVisible(WRONG_EMAIL_MESSAGE_LOCATOR, Browser.SHORT_TIMEOUT_SECONDS);
    }
}
