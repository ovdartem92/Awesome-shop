package service;

import model.User;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profile_screen.ProfileScreen;

/**
 * This is a service class that performs logic during login and logout.
 */
public class AccountService {
    /**
     * This method performs actions for the login to the system.
     *
     * @param user is required to get login information
     */
    public void logIn(User user) {
        new LogInScreen()
                .clickContinueWithEmailButton()
                .typeTextToEmailField(user.getEmail())
                .clickNextButton()
                .typeTextToPasswordField(user.getPassword())
                .clickLogInButton()
                .waitMarketingConsentButtonAvailable()
                .clickCloseModalButton();
    }
    /**
     * This method performs actions for the LogOut from the system.
     *
     */
    public void logOut() {
        new ProfileScreen()
                .clickLogOutButton()
                .clickConfirmLogOutButton();
    }
}
