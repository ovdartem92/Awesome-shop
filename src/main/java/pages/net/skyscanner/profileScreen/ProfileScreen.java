package pages.net.skyscanner.profileScreen;

import pages.AbstractScreen;
import service.CultureService;
import service.LogInService;
import utils.Constants;

public class ProfileScreen extends AbstractScreen {
    private static final String LOG_OUT_BUTTON_PATH = "//button[contains(text(), 'Log out')]";
    private static final String SECOND_LOG_OUT_BUTTON_PATH = "//*[@id='delete-dialog']/div/button[2]";

    public ProfileScreen switchToEnglish() {
        new CultureService().changeLanguage(Constants.ENGLISH_LANGUAGE);
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

    public void logOut() {
        LogInService.LogOut();
    }
}
