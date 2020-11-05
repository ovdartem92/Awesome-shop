package pages.net.skyscanner.profilePage;

import pages.AbstractScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.CultureService;
import service.LogInService;
import utils.Constants;

public class ProfilePage extends AbstractScreen {
    private static final String LOG_OUT_BUTTON_PATH = "//button[contains(text(), 'Log out')]";
    private static final String SECOND_LOG_OUT_BUTTON_PATH = "//*[@id='delete-dialog']/div/button[2]";

    public ProfilePage switchToEnglish() {
        CultureService.changeLanguage(Constants.ENGLISH_LANGUAGE);
        return this;
    }

    public HeaderScreen headerScreenGetInstance() {
        return new HeaderScreen();
    }

    public ProfilePage clickOnLogOutButton() {
        clickOnElement(LOG_OUT_BUTTON_PATH);
        return new ProfilePage();
    }

    public ProfilePage clickOnSecondLogOutButton() {
        clickOnElement(SECOND_LOG_OUT_BUTTON_PATH);
        return new ProfilePage();
    }

    public void logOut() {
        LogInService.LogOut();
    }
}
