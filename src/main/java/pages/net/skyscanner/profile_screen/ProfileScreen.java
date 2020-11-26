package pages.net.skyscanner.profile_screen;

import pages.AbstractScreen;
import service.WaitManager;

public class ProfileScreen extends AbstractScreen {
    private static final String LOG_OUT_BUTTON_LOCATOR = "//*[contains(@class,'DialogButton_OpenDialogButton')]";
    private static final String CONFIRM_LOG_OUT_BUTTON_LOCATOR = "//*[contains(@class,'DialogButton_ActionButton')]";
    private static final String ADD_A_TRAVELER_BUTTON_LOCATOR = "//*[contains(@class,'single-line')]";
    private static final String DIALOG_BUTTON_LOCATOR = "//div[contains(@class,'Traveller')]//button";
    private static final String CONFIRM_DELETE_BUTTON_LOCATOR = "//*[@id='delete-dialog']/div/button[2]";
    private static final String DELETE_MESSAGE_LOCATOR = "//*[contains(@class,'AsyncActionDialogButton')]";
    private static final String FIRST_NAME_FIELD_LOCATOR = "//*[@id='firstName']";
    private static final String LAST_NAME_FIELD_LOCATOR = "//*[@id='lastName']";
    private static final String PLACE_OF_BIRTH_FIELD_LOCATOR = "//*[@id='placeOfBirth']";

    public ProfileScreen clickLogOutButton() {
        clickOnElement(LOG_OUT_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickConfirmLogOutButton() {
        clickOnElement(CONFIRM_LOG_OUT_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen typeTextToFirstNameField(String txt) {
        typeTextToElement(FIRST_NAME_FIELD_LOCATOR, txt);
        return this;
    }

    public ProfileScreen typeTextToLastNameField(String txt) {
        typeTextToElement(LAST_NAME_FIELD_LOCATOR, txt);
        return this;
    }

    public ProfileScreen typeTextToPlaceOfBirthField(String txt) {
        typeTextToElement(PLACE_OF_BIRTH_FIELD_LOCATOR, txt);
        return this;
    }

    public ProfileScreen clickAddTravelerButton() {
        clickOnElement(ADD_A_TRAVELER_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickDialogButton() {
        clickOnElement(DIALOG_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickConfirmDeleteTravelerButton() {
        clickOnElement(CONFIRM_DELETE_BUTTON_LOCATOR);
        return this;
    }

    public boolean isDeleteMessageDisplayed() {
        return WaitManager.isElementVisible(DELETE_MESSAGE_LOCATOR, 2);
    }
}
