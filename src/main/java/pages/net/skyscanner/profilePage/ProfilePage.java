package pages.net.skyscanner.profilePage;

import model.User;
import pages.AbstractPage;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.elements.RegionalSettingsScreen;
import service.CultureService;
import service.LogInService;
import utils.Constants;

public class ProfilePage extends AbstractPage {
    private static final String ACCOUNT_FIELD_PATH = "//span[contains(text(), 'Account')]";
    private static final String EMAIL_FIELD_PATH = "//span[contains(text(), '%s')]";
    private static final String LOG_OUT_BUTTON_PATH = "//button[contains(text(), 'Log out')]";
    private static final String SECOND_LOG_OUT_BUTTON_PATH = "//*[@id='delete-dialog']/div/button[2]";

    public ProfilePage clickOnAccountField() {
        clickOnElement(ACCOUNT_FIELD_PATH);
        return this;
    }

    public ProfilePage switchToEnglish() {
        CultureService.changeLanguage(Constants.ENGLISH_LANGUAGE);
        return this;
    }

    public HeaderScreen headerScreen() {
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
