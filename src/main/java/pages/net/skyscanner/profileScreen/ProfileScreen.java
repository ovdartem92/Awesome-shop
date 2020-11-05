package pages.net.skyscanner.profileScreen;

import pages.AbstractScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.LogInService;
import utils.Constants;

public class ProfileScreen extends AbstractScreen {
    private static final String LOG_OUT_BUTTON_PATH = "//button[contains(text(), 'Log out')]";
    private static final String SECOND_LOG_OUT_BUTTON_PATH = "//*[@id='delete-dialog']/div/button[2]";

    public ProfileScreen switchToEnglish() {
        AbstractScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        return this;
    }

    public ProfileScreen clickToLogOutButton() {
        clickOnElement(LOG_OUT_BUTTON_PATH);
        return new ProfileScreen();
    }

    public ProfileScreen clickToSecondLogOutButton() {
        clickOnElement(SECOND_LOG_OUT_BUTTON_PATH);
        return new ProfileScreen();
    }

    public HeaderScreen logOut() {
        LogInService.logOut();
        return new HeaderScreen();
    }
}
