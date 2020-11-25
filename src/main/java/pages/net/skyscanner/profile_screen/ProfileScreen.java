package pages.net.skyscanner.profile_screen;

import pages.AbstractScreen;

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
}
