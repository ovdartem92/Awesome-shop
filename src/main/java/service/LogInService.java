package service;

import model.User;
import pages.AbstractPage;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profilePage.ProfilePage;

public class LogInService {

    public static void LogIn(User user) {
        LogInScreen logInScreen = new LogInScreen().clickToContinueWithEmail();
        AbstractPage.typeTextToElement(LogInScreen.getEmailFieldLocator(), user.getEmail());
        logInScreen.clickToNext();
        AbstractPage.typeTextToElement(LogInScreen.getPasswordFieldLocator(), user.getPassword());
        logInScreen.clickToLogIn().clickToCloseModal();
    }

    public static void LogOut() {
        new ProfilePage()
                .clickOnLogOutButton()
                .clickOnSecondLogOutButton();
    }
}
