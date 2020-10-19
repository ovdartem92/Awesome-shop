package page.net.skyscanner;

import model.User;
import org.openqa.selenium.By;
import page.AbstractPage;
import page.net.skyscanner.hotel.SkyScannerSearchHotelPage;

import static service.ActionManager.*;
import static util.CaptchaMethod.*;


public class SkyScannerHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.skyscanner.net/";
    private static final By LOG_IN_BUTTON_LOCATOR = By.xpath("//span[text()='Log in']");
    private static final By ACCOUNT_BUTTON_LOCATOR = By.xpath("//span[text()='Account']");
    private static final By EMAIL_FIELD_LOCATOR = By.id("email");
    private static final By NEXT_BUTTON_LOCATOR = By.id("login-modal");
    private static final By PASSWORD_FIELD_LOCATOR = By.id("password");
    private static final By CONTINUE_WITH_EMAIL_BUTTON_LOCATOR = By.xpath("//button[@data-testid='login-email-button']");
    private static final By ACCOUNT_DETECTED_BUTTON_LOCATOR = By.xpath("//button[@data-testid='account-detection-button']");
    private static final By SECOND_LOG_IN_BUTTON_LOCATOR = By.xpath("//button[@data-testid='login-button']");
    private static final By CLOSE_MODAL_LOGIN_WINDOW_BUTTON_LOCATOR = By.xpath("//button[@title='Close modal']");

    // Tab WebElements.
    private static final By FLIGHTS_TAB_LOCATOR = By.xpath("//nav[@id='PrimaryNav']//span[contains(text(), 'Flights')]");
    private static final By HOTEL_TAB_LOCATOR = By.xpath("//nav[@id='PrimaryNav']//span[contains(text(), 'Hotels')]");
    private static final By CAR_HIRE_TAB_LOCATOR = By.xpath("//a[@id='carhi']");
    private static final By SEARCH_FLIGHTS_BUTTON_LOCATOR = By.xpath("//button[text()='Search flights']");

    public SkyScannerHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SkyScannerHomePage logIn(User user) {
        clickOnElementBy(LOG_IN_BUTTON_LOCATOR);
        clickOnElementBy(NEXT_BUTTON_LOCATOR);
        clickOnElementBy(CONTINUE_WITH_EMAIL_BUTTON_LOCATOR);
        typeTextToElementBy(EMAIL_FIELD_LOCATOR, user.getEmail());
        clickOnElementBy(ACCOUNT_DETECTED_BUTTON_LOCATOR);
        typeTextToElementBy(PASSWORD_FIELD_LOCATOR, user.getPassword());
        clickOnElementBy(SECOND_LOG_IN_BUTTON_LOCATOR);
        clickOnElementBy(CLOSE_MODAL_LOGIN_WINDOW_BUTTON_LOCATOR);
        checkCaptchaOnPage(logger);
        return this;
    }

    // Click to tabs.
    public SkyScannerSearchHotelPage clickToHostelsTab() {
        clickOnElementBy(HOTEL_TAB_LOCATOR);
        logger.info(("Clicked on HOSTEL_TAB"));
        return new SkyScannerSearchHotelPage();
    }

    public SkyScannerHomePage clickToFlightsTab() {
        clickOnElementBy(FLIGHTS_TAB_LOCATOR);
        logger.info(("Clicked on FLIGHTS_TAB"));
        return this;
    }

    public SkyScannerCarSearchPage clickToCarHireTab() {
        clickOnElementBy(CAR_HIRE_TAB_LOCATOR);
        logger.info(("Clicked on CAR_HIRE_TAB"));
        return new SkyScannerCarSearchPage();
    }

    public SkyScannerFlightsResultsPage startFlightsSearch() {
        clickOnElementBy(SEARCH_FLIGHTS_BUTTON_LOCATOR);
        return new SkyScannerFlightsResultsPage();
    }

    public SkyScannerProfilePage openProfilePage() {
        clickOnElementBy(ACCOUNT_BUTTON_LOCATOR);
        return new SkyScannerProfilePage();
    }

    public String getTextFromFlightsButton() {
        return getTextOnElementBy(SEARCH_FLIGHTS_BUTTON_LOCATOR);
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }
}
