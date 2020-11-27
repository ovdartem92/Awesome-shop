package service;

import model.User;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profile_screen.ProfileScreen;

/**
 * This is a service class that performs logic during login and logout.
 */
public class AccountService {
    private ProfileScreen profileScreen = new ProfileScreen();

    /**
     * This method performs actions for the login to the system.
     *
     * @param user is required to get login information
     */
    public void logIn(User user) {
        new LogInScreen()
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
        profileScreen
                .clickLogOutButton()
                .clickConfirmLogOutButton();
    }

    public void createTraveler(User user) {
        profileScreen
                .clickAddTravelerButton()
                .typeTextToFirstNameField(user.getFirstName())
                .typeTextToLastNameField(user.getLastName())
                .typeTextToPlaceOfBirthField(user.getCity())
                .clickDialogButton();
    }

    public void deleteTraveler() {
        profileScreen
                .clickDialogButton()
                .clickConfirmDeleteTravelerButton();
    }
}
