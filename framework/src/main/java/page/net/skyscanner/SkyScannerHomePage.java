package page.net.skyscanner;

import model.User;
import page.AbstractPage;
import page.net.skyscanner.car.SkyScannerCarSearchPage;
import page.net.skyscanner.help.SkyScannerHelpPage;
import page.net.skyscanner.hotel.SkyScannerSearchHotelPage;

import static service.ActionManager.*;
import static util.CaptchaMethod.*;

public class SkyScannerHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.skyscanner.net/";
    private static final String LOG_IN_BUTTON_PATH = "//span[text()='Log in']";
    private static final String ACCOUNT_BUTTON_PATH = "//span[text()='Account']";
    private static final String LANGUAGE_PATH = "//li[@id='culture-info']//div/span";
    private static final String LANGUAGES_SELECT_PATH = "//select[@name='locale']";
    private static final String ENGLISH_LANGUAGE_OPTION_PATH = "//select[@name='locale']//option[@value='en-US']";
    private static final String CULTURE_SAVE_BUTTON_PATH = "//button[@id='culture-selector-save']";
    private static final String EMAIL_FIELD_PATH = "//input[@id='email']";
    private static final String NEXT_BUTTON_PATH = "//*[@id='login-modal']";
    private static final String PASSWORD_FIELD_PATH = "//input[@id='password']";
    private static final String CONTINUE_WITH_EMAIL_BUTTON_PATH = "//button[@data-testid='login-email-button']";
    private static final String ACCOUNT_DETECTED_BUTTON_PATH = "//button[@data-testid='account-detection-button']";
    private static final String SECOND_LOG_IN_BUTTON_PATH = "//button[@data-testid='login-button']";
    private static final String CLOSE_MODAL_LOGIN_WINDOW_BUTTON_PATH = "//button[@title='Close modal']";
    private static final String HELP_LINK_PATH = "//a[@id='ss-footer-links-faq']";

    private static final String FLIGHTS_TAB_PATH = "//nav[@id='PrimaryNav']//span[contains(text(), 'Flights')]";
    private static final String HOTEL_TAB_PATH = "//nav[@id='PrimaryNav']//span[contains(text(), 'Hotels')]";
    private static final String CAR_HIRE_TAB_PATH = "//a[@id='carhi']";
    private static final String SEARCH_FLIGHTS_BUTTON_PATH = "//button[text()='Search flights']";

    public SkyScannerHomePage logIn(User user) {
        clickOnElementBy(LOG_IN_BUTTON_PATH);
        clickOnElementBy(NEXT_BUTTON_PATH);
        clickOnElementBy(CONTINUE_WITH_EMAIL_BUTTON_PATH);
        typeTextToElementBy(EMAIL_FIELD_PATH, user.getEmail());
        clickOnElementBy(ACCOUNT_DETECTED_BUTTON_PATH);
        typeTextToElementBy(PASSWORD_FIELD_PATH, user.getPassword());
        clickOnElementBy(SECOND_LOG_IN_BUTTON_PATH);
        clickOnElementBy(CLOSE_MODAL_LOGIN_WINDOW_BUTTON_PATH);
        checkCaptchaOnPage(logger);
        return this;
    }

    public SkyScannerSearchHotelPage clickToHostelsTab() {
        clickOnElementBy(HOTEL_TAB_PATH);
        logger.info(("Clicked on HOSTEL_TAB"));
        return new SkyScannerSearchHotelPage();
    }

    public SkyScannerHomePage clickToFlightsTab() {
        clickOnElementBy(FLIGHTS_TAB_PATH);
        logger.info(("Clicked on FLIGHTS_TAB"));
        return this;
    }

    public SkyScannerCarSearchPage clickToCarHireTab() {
        clickOnElementBy(CAR_HIRE_TAB_PATH);
        logger.info(("Clicked on CAR_HIRE_TAB"));
        return new SkyScannerCarSearchPage();
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

    @Override
    public SkyScannerHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
}
