package service;

import model.User;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profile_screen.ProfileScreen;

public class AccountService {
    private final LogInScreen logInScreen = new LogInScreen();
    private final ProfileScreen profileScreen = new ProfileScreen();

    public void logIn(User user) {
        logInScreen
                .clickContinueWithEmailButton()
                .typeTextToEmailField(user.getEmail())
                .clickNextButton()
                .typeTextToPasswordField(user.getPassword())
                .clickLogInButton()
                .waitMarketingConsentButtonAvailable()
                .clickCloseModalButton();
    }

    public void logOut() {
        profileScreen
                .clickLogOutButton()
                .clickConfirmLogOutButton();
    }
}
