package pages.net.skyscanner.profileScreen;

import pages.AbstractScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;

public class ProfileScreen extends AbstractScreen {
    private static final String LOG_OUT_BUTTON_PATH = "//*[contains(@class,'DialogButton_OpenDialogButton')]";
    private static final String SECOND_LOG_OUT_BUTTON_PATH = "//*[contains(@class,'DialogButton_ActionButton')]";

    public ProfileScreen clickLogOutButton() {
        clickOnElement(LOG_OUT_BUTTON_PATH);
        return this;
    }

    public ProfileScreen clickSecondLogOutButton() {
        clickOnElement(SECOND_LOG_OUT_BUTTON_PATH);
        return this;
    }

    public HeaderScreen logOut() {
        new AccountService().logOut();
        return new HeaderScreen();
    }
}
