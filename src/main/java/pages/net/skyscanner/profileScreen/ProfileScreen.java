package pages.net.skyscanner.profileScreen;

import pages.AbstractScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;

public class ProfileScreen extends AbstractScreen {
    private static final String LOG_OUT_BUTTON_LOCATOR = "//*[contains(@class,'DialogButton_OpenDialogButton')]";
    private static final String CONFIRM_LOG_OUT_BUTTON_LOCATOR = "//*[contains(@class,'DialogButton_ActionButton')]";

    public ProfileScreen clickLogOutButton() {
        clickOnElement(LOG_OUT_BUTTON_LOCATOR);
        return this;
    }

    public ProfileScreen clickConfirmLogOutButton() {
        clickOnElement(CONFIRM_LOG_OUT_BUTTON_LOCATOR);
        return this;
    }

    public HeaderScreen logOut() {
        new AccountService().logOut();
        return header;
    }
}
