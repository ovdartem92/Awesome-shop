package service;

import model.User;
import pages.net.skyscanner.elements.LogInScreen;

/**
 * This is a service class that performs logic during login and logout.
 */
public class AccountService {
    private final LogInScreen logInScreen = new LogInScreen();

    /**
     * This method performs actions for the login to the system.
     *
     * @param user is required to get login information
     */
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
}
