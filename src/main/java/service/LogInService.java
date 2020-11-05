package service;

import model.User;
import pages.AbstractScreen;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profileScreen.ProfileScreen;

public abstract class LogInService {

    public static void logIn(User user) {
        LogInScreen logInScreen = new LogInScreen().clickToContinueWithEmailButton();
        AbstractScreen.typeTextToElement(LogInScreen.getEmailFieldLocator(), user.getEmail());
        logInScreen.clickToNextButton();
        AbstractScreen.typeTextToElement(LogInScreen.getPasswordFieldLocator(), user.getPassword());
        logInScreen.clickToLogInButton();
        if(!logInScreen.isWrongEmailOrPasswordMessageDisplayed()) {
            logInScreen.waitToMarketingConsentButtonAvailable();
        }
        logInScreen.clickToCloseModalButton();
    }

    public static void logOut() {
        new ProfileScreen()
                .clickToLogOutButton()
                .clickToSecondLogOutButton();
    }
}
