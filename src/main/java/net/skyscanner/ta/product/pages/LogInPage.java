package net.skyscanner.ta.product.pages;

import driver.Browser;
import pages.AbstractScreen;
import service.WaitManager;

public class LogInPage extends AbstractScreen {
    private static final String CONTINUE_WITH_EMAIL_BUTTON_LOCATOR = "//button[@data-testid='login-email-button']";
    private static final String ACCOUNT_DETECTED_BUTTON_LOCATOR = "//button[@data-testid='account-detection-button']";
    private static final String LOG_IN_BUTTON_LOCATOR = "//button[@data-testid='login-button']";
    private static final String WRONG_EMAIL_MESSAGE_LOCATOR = "//span[contains(@class,'banner-alert__icon')]";
    private static final String EMAIL_FIELD_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_FIELD_LOCATOR = "//input[@id='password']";

    public LogInPage typeTextToEmailField(String txt) {
        typeTextToElement(EMAIL_FIELD_LOCATOR, txt);
        return this;
    }

    public LogInPage typeTextToPasswordField(String txt) {
        typeTextToElement(PASSWORD_FIELD_LOCATOR, txt);
        return this;
    }

    public LogInPage clickContinueWithEmailButton() {
        clickOnElement(CONTINUE_WITH_EMAIL_BUTTON_LOCATOR);
        return this;
    }

    public LogInPage clickNextButton() {
        clickOnElement(ACCOUNT_DETECTED_BUTTON_LOCATOR);
        return this;
    }

    public LogInPage clickLogInButton() {
        clickOnElement(LOG_IN_BUTTON_LOCATOR);
        return this;
    }

    public Boolean isWrongEmailMessageDisplayed() {
        return WaitManager.isElementVisible(WRONG_EMAIL_MESSAGE_LOCATOR, Browser.SHORT_TIMEOUT_SECONDS);
    }
}
