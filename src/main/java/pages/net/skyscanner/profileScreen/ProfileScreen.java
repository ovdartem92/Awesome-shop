package pages.net.skyscanner.profileScreen;

import pages.AbstractScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;
import utils.Constants;

public class ProfileScreen extends AbstractScreen {
    private static final String LOG_OUT_BUTTON_PATH = "//button[contains(text(), 'Log out')]";
    private static final String SECOND_LOG_OUT_BUTTON_PATH = "//*[@id='delete-dialog']/div/button[2]";

    public ProfileScreen clickLogOutButton() {
        AbstractScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
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
