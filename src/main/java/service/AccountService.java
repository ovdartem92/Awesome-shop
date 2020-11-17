package service;

import model.User;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profileScreen.ProfileScreen;

public class AccountService {
    private LogInScreen logInScreen = new LogInScreen();
    private ProfileScreen profileScreen = new ProfileScreen();

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

    public void createTraveler(User user) {
        profileScreen
                .clickAddTravelerButton()
                .typeTextToFirstNameField(user.getName())
                .typeTextToLastNameField(user.getLastName())
                .typeTextToPlaceOfBirthField(user.getCity())
                .clickSaveTravelerButton();
    }

    public void deleteTraveler() {
        profileScreen
                .clickDeleteTravelerButton()
                .clickConfirmDeleteTravelerButton();
    }
}
