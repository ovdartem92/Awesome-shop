package service;

import model.User;
import pages.AbstractScreen;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profileScreen.ProfileScreen;

public class AccountService {
    private static final String EMAIL_FIELD_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_FIELD_LOCATOR = "//input[@id='password']";

    public void logIn(User user) {
        LogInScreen logInScreen = new LogInScreen().clickContinueWithEmailButton();
        AbstractScreen.typeTextToElement(EMAIL_FIELD_LOCATOR, user.getEmail());
        logInScreen.clickNextButton();
        AbstractScreen.typeTextToElement(PASSWORD_FIELD_LOCATOR, user.getPassword());
        logInScreen.clickLogInButton();
        logInScreen.waitMarketingConsentButtonAvailable();
        logInScreen.clickCloseModalButton();
    }

    public void logOut() {
        new ProfileScreen()
                .clickLogOutButton()
                .clickSecondLogOutButton();
    }
}
