package service;

import model.User;
import pages.AbstractScreen;
import pages.net.skyscanner.elements.LogInScreen;
import pages.net.skyscanner.profileScreen.ProfileScreen;

public class AccountService {
    private static final String EMAIL_FIELD_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_FIELD_LOCATOR = "//input[@id='password']";
    private static final String FIRST_NAME_FIELD_LOCATOR = "//*[@id='firstName']";
    private static final String LAST_NAME_FIELD_LOCATOR = "//*[@id='lastName']";
    private static final String PLACE_OF_BIRTH_FIELD_LOCATOR = "//*[@id='placeOfBirth']";
    private LogInScreen logInScreen = new LogInScreen();
    private ProfileScreen profileScreen = new ProfileScreen();

    public void logIn(User user) {
        logInScreen.clickContinueWithEmailButton();
        AbstractScreen.typeTextToElement(EMAIL_FIELD_LOCATOR, user.getEmail());
        logInScreen.clickNextButton();
        AbstractScreen.typeTextToElement(PASSWORD_FIELD_LOCATOR, user.getPassword());
        logInScreen.clickLogInButton();
        logInScreen.waitMarketingConsentButtonAvailable();
        logInScreen.clickCloseModalButton();
    }

    public void logOut() {
        profileScreen
                .clickLogOutButton()
                .clickConfirmLogOutButton();
    }

    public void createTraveler(User user) {
        profileScreen.clickAddTravelerButton();
        AbstractScreen.typeTextToElement(FIRST_NAME_FIELD_LOCATOR, user.getName());
        AbstractScreen.typeTextToElement(LAST_NAME_FIELD_LOCATOR, user.getLastName());
        AbstractScreen.typeTextToElement(PLACE_OF_BIRTH_FIELD_LOCATOR, user.getCity());
        profileScreen.clickSaveTravelerButton();
    }

    public void deleteTraveler() {
        profileScreen
                .clickDeleteTravelerButton()
                .clickConfirmDeleteTravelerButton();
    }
}
