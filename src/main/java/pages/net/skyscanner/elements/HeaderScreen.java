package pages.net.skyscanner.elements;

import pages.AbstractScreen;
import pages.net.skyscanner.profileScreen.ProfileScreen;
import service.WaitManager;

public class HeaderScreen extends AbstractScreen {
    private static final String CULTURE_SETTING_BUTTON_LOCATOR = "//li[@id='culture-info']//button";
    private static final String LOG_IN_BUTTON_LOCATOR = "//span[text()='Log in']";
    private static final String ACCOUNT_BUTTON_LOCATOR = "//*[@id='login-button-nav-item']/button";

    public LogInScreen clickLoginButton() {
        clickOnElement(LOG_IN_BUTTON_LOCATOR);
        return new LogInScreen();
    }

    public ProfileScreen clickAccountButton() {
        clickOnElement(ACCOUNT_BUTTON_LOCATOR);
        return new ProfileScreen();
    }

    public boolean isLoginButtonDisplayed() {
        return WaitManager.isElementVisible(LOG_IN_BUTTON_LOCATOR,2);
    }

    public RegionalSettingsScreen clickRegionalSettingsButton() {
        clickOnElement(CULTURE_SETTING_BUTTON_LOCATOR);
        return new RegionalSettingsScreen();
    }
}
