package pages.net.skyscanner.profileScreen;

import model.User;
import pages.AbstractScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;
import service.WaitManager;

public class ProfileScreen extends AbstractScreen {
    private static final String LOG_OUT_BUTTON_LOCATOR = "//*[contains(@class,'DialogButton_OpenDialogButton')]";
    private static final String CONFIRM_LOG_OUT_BUTTON_LOCATOR = "//*[contains(@class,'DialogButton_ActionButton')]";
    private static final String ADD_A_TRAVELER_BUTTON_LOCATOR = "//*[contains(@class,'single-line')]";
    private static final String TRAVELER_BUTTON_LOCATOR = "//div[contains(@class,'Traveller')]//button";
    private static final String CONFIRM_DELETE_BUTTON_LOCATOR = "//*[@id='delete-dialog']/div/button[2]";
    private static final String DELETE_MESSAGE_LOCATOR = "//*[contains(@class,'AsyncActionDialogButton')]";

    public ProfileScreen clickLogOutButton() {
        clickOnElement(LOG_OUT_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickConfirmLogOutButton() {
        clickOnElement(CONFIRM_LOG_OUT_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickAddTravelerButton() {
        clickOnElement(ADD_A_TRAVELER_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickSaveTravelerButton() {
        clickOnElement(TRAVELER_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickDeleteTravelerButton() {
        clickOnElement(TRAVELER_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickConfirmDeleteTravelerButton() {
        clickOnElement(CONFIRM_DELETE_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen addTraveler(User user) {
        new AccountService().createTraveler(user);
        return this;
    }

    public ProfileScreen deleteTraveler() {
        new AccountService().deleteTraveler();
        return this;
    }

    public boolean isDeleteMessageDisplayed() {
        return WaitManager.isElementVisible(DELETE_MESSAGE_LOCATOR, 2);
    }

    public HeaderScreen logOut() {
        new AccountService().logOut();
        return header;
    }
}
