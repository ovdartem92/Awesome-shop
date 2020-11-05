package service;

import model.User;
import pages.AbstractScreen;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profilePage.ProfilePage;

public class LogInService {

    public static void LogIn(User user) {
        LogInScreen logInScreen = new LogInScreen().clickToContinueWithEmail();
        AbstractScreen.typeTextToElement(LogInScreen.getEmailFieldLocator(), user.getEmail());
        logInScreen.clickToNextButton();
        AbstractScreen.typeTextToElement(LogInScreen.getPasswordFieldLocator(), user.getPassword());
        logInScreen.clickToLogInButton();
        if(!logInScreen.isWrongEmailOrPasswordMessageDisplayed()) {
            logInScreen.waitMarketingConsentButtonAvailable();
        }
        logInScreen.clickToCloseModal();
    }

    public static void LogOut() {
        new ProfilePage()
                .clickOnLogOutButton()
                .clickOnSecondLogOutButton();
    }
}
