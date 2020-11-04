package pages.net.skyscanner.elements;

import model.User;
import pages.AbstractPage;
import service.LogInService;

public class LogInScreen extends AbstractPage {
    private static final String CONTINUE_WITH_EMAIL_BUTTON_LOCATOR = "//button[@data-testid='login-email-button']";
    private static final String ACCOUNT_DETECTED_BUTTON_LOCATOR = "//button[@data-testid='account-detection-button']";
    private static final String LOG_IN_BUTTON_LOCATOR = "//button[@data-testid='login-button']";
    private static final String CLOSE_MODAL_LOGIN_WINDOW_BUTTON_LOCATOR = "//button[@title='Close modal']";
    private static final String EMAIL_FIELD_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_FIELD_LOCATOR = "//input[@id='password']";

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

    public LogInScreen clickToNext() {
        clickOnElement(ACCOUNT_DETECTED_BUTTON_LOCATOR);
        return this;
    }

    public LogInScreen clickToLogIn() {
        clickOnElement(LOG_IN_BUTTON_LOCATOR);
        return this;
    }

    public LogInScreen clickToCloseModal() {
        clickOnElement(CLOSE_MODAL_LOGIN_WINDOW_BUTTON_LOCATOR);
        return this;
    }

    public HeaderScreen logIn(User user) {
        LogInService.LogIn(user);
        return new HeaderScreen();
    }
}
