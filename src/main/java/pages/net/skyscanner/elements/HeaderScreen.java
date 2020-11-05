package pages.net.skyscanner.elements;

import pages.AbstractScreen;
import pages.net.skyscanner.profilePage.ProfilePage;
import service.WaitManager;

public class HeaderScreen extends AbstractScreen {
    private static final String CULTURE_SETTING_BUTTON_LOCATOR = "//li[@id='culture-info']//button";
    private static final String LOG_IN_BUTTON_LOCATOR = "//span[text()='Log in']";
    private static final String ACCOUNT_BUTTON_LOCATOR = "//*[@id='login-button-nav-item']/button";

    public LogInScreen clickToLoginButton() {
        clickOnElement(LOG_IN_BUTTON_LOCATOR);
        return new LogInScreen();
    }

    public ProfilePage clickToAccountButton() {
        clickOnElement(ACCOUNT_BUTTON_LOCATOR);
        return new ProfilePage();
    }

    public boolean isLoginButtonDisplayed() {
        return WaitManager.isElementDisplayed(LOG_IN_BUTTON_LOCATOR);
    }

    public RegionalSettingsScreen clickRegionalSettingsButton() {
        clickOnElement(CULTURE_SETTING_BUTTON_LOCATOR);
        return new RegionalSettingsScreen();
    }
}
