package page.net.skyscanner;

import model.User;
import page.AbstractPage;
import page.net.skyscanner.flights.SkyScannerFlightsResultsPage;
import page.net.skyscanner.help.SkyScannerHelpPage;

import static service.ActionManager.*;
import static service.WaitManager.isElementVisibleBy;
import static service.WaitManager.waitForElementLocatedBy;
import static util.CaptchaMethod.*;

public class SkyScannerHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.skyscanner.net/";
    private static final String LOG_IN_BUTTON_PATH = "//span[text()='Log in']";
    private static final String ACCOUNT_BUTTON_PATH = "//*[@id='login-button-nav-item']/button";
    private static final String MARKETING_CONSENT_BUTTON_PATH = "//button[@data-testid='btn-marketing-consent-cta']";
    private static final String WRONG_EMAIL_OR_PASSWORD_PATH = "//span[text()='Wrong email or password']";
    private static final String EMAIL_FIELD_PATH = "//input[@id='email']";
    private static final String NEXT_BUTTON_PATH = "//*[@id='login-modal']";
    private static final String PASSWORD_FIELD_PATH = "//input[@id='password']";
    private static final String CONTINUE_WITH_EMAIL_BUTTON_PATH = "//button[@data-testid='login-email-button']";
    private static final String ACCOUNT_DETECTED_BUTTON_PATH = "//button[@data-testid='account-detection-button']";
    private static final String SECOND_LOG_IN_BUTTON_PATH = "//button[@data-testid='login-button']";
    private static final String CLOSE_MODAL_LOGIN_WINDOW_BUTTON_PATH = "//button[@title='Close modal']";
    private static final String HELP_LINK_PATH = "//a[@id='ss-footer-links-faq']";

    public SkyScannerHomePage logIn(User user) {
        clickOnElementBy(LOG_IN_BUTTON_PATH);
        clickOnElementBy(NEXT_BUTTON_PATH);
        clickOnElementBy(CONTINUE_WITH_EMAIL_BUTTON_PATH);
        typeTextToElementBy(EMAIL_FIELD_PATH, user.getEmail());
        clickOnElementBy(ACCOUNT_DETECTED_BUTTON_PATH);
        typeTextToElementBy(PASSWORD_FIELD_PATH, user.getPassword());
        clickOnElementBy(SECOND_LOG_IN_BUTTON_PATH);
        if (!isElementVisibleBy(WRONG_EMAIL_OR_PASSWORD_PATH)) {
            waitForElementLocatedBy(MARKETING_CONSENT_BUTTON_PATH);
            clickOnElementBy(CLOSE_MODAL_LOGIN_WINDOW_BUTTON_PATH);
        }
        clickOnElementBy(CLOSE_MODAL_LOGIN_WINDOW_BUTTON_PATH);
        checkCaptchaOnPage(logger);
        return this;
    }

    public boolean isAccountButtonActive() {
        return isElementVisibleBy(ACCOUNT_BUTTON_PATH);
    }

    public boolean isLogInButtonActive() {
        return isElementVisibleBy(LOG_IN_BUTTON_PATH);
    }

    public SkyScannerFlightsResultsPage startFlightsSearch() {
        clickOnElementBy(SEARCH_FLIGHTS_BUTTON_PATH);
        return new SkyScannerFlightsResultsPage();
    }

    public SkyScannerProfilePage openProfilePage() {
        clickOnElementBy(ACCOUNT_BUTTON_PATH);
        return new SkyScannerProfilePage();
    }

    public SkyScannerHelpPage clickToHelpLink() {
        clickOnElementBy(HELP_LINK_PATH);
        return new SkyScannerHelpPage();
    }

    public String getTextFromFlightsButton() {
        return getTextOnElementBy(SEARCH_FLIGHTS_BUTTON_PATH);
    }

    public SkyScannerHomePage switchToEnglish() {
        String language = getTextOnElementBy(LANGUAGE_PATH);

        if (!language.equals("English (UK)")) {
            clickOnElementBy(LANGUAGE_PATH);
            clickOnElementBy(LANGUAGES_SELECT_PATH);
            clickOnElementBy(ENGLISH_LANGUAGE_OPTION_PATH);
            clickOnElementBy(CULTURE_SAVE_BUTTON_PATH);
        }
        return this;
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }
}
