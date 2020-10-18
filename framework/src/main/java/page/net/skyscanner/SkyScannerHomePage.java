package page.net.skyscanner;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static util.Utils.checkCaptchaOnPage;
import static util.Utils.waitForElementLocatedBy;

public class SkyScannerHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.skyscanner.net/";
    private final Logger LOGGER = LogManager.getRootLogger();

    private static final By CAPTCHA_ELEMENT = By.xpath("//*[contains(text(), 'Are you a person or a robot?')]");
    private static final By LOG_IN_BUTTON = By.xpath("//span[text()='Log in']");
    private static final By ACCOUNT_BUTTON = By.xpath("//span[text()='Account']");
    private static final By EMAIL_FIELD = By.id("email");
    private static final By NEXT_BUTTON = By.id("login-modal");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By CONTINUE_WITH_EMAIL_BUTTON = By.xpath("//button[@data-testid='login-email-button']");
    private static final By ACCOUNT_DETECTED_BUTTON = By.xpath("//button[@data-testid='account-detection-button']");
    private static final By SECOND_LOG_IN_BUTTON = By.xpath("//button[@data-testid='login-button']");
    private static final By CLOSE_MODAL_LOGIN_WINDOW_BUTTON = By.xpath("//button[@title='Close modal']");

    // Tab WebElements.
    private static final By FLIGHTS_TAB = By.xpath("//nav[@id='PrimaryNav']//span[contains(text(), 'Flights')]");
    private static final By HOSTEL_TAB = By.xpath("//nav[@id='PrimaryNav']//span[contains(text(), 'Hotels')]");
    private static final By CAR_HIRE_TAB = By.xpath("//a[@id='carhi']");
    private static final By CAR_HEADER = By.xpath("//div[@class='SearchControls_search-controls-title__27T3N']");
    private static final By SEARCH_FLIGHTS_BUTTON = By.xpath("//button[text()='Search flights']");

    // Hotels WebElements.
    private static final By DESTINATION_OR_HOSTEL_NAME_INPUT = By.xpath("//input[@name='destination-autosuggest']");
    private static final By HOSTEL_CHECK_IN_INPUT = By.xpath("//input[@id='checkin']");
    private static final By HOSTEL_CHECK_OUT_INPUT = By.xpath("//input[@id='checkout']");
    private static final By GUESTS_AND_ROOM_INPUT = By.xpath("//input[@id='guests-rooms']");
    private static final By SEARCH_HOTEL_BUTTON = By.xpath("//button[contains(text(), 'Search hotels')]");

    public SkyScannerFlightsResultsPage startFlightsSearch() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(SEARCH_FLIGHTS_BUTTON));
        driver.findElement(SEARCH_FLIGHTS_BUTTON).click();
        return new SkyScannerFlightsResultsPage(driver);
    }

    // Hotels guests and rooms WebElements.
    private static final By QUANTITY_ROOMS_INPUT = By.xpath("//input[@id='rooms']");
    private static final By INCREASE_ROOM_BUTTON = By.xpath("//button[@aria-controls='rooms'][@title='Increase']");
    private static final By DECREASE_ROOM_BUTTON = By.xpath("//button[@aria-controls='rooms'][@title='Decrease']");
    private static final By QUANTITY_ADULT_PEOPLE_INPUT = By.xpath("//input[@id='adults']");
    private static final By INCREASE_ADULT_BUTTON = By.xpath("//button[@aria-controls='adults'][@title='Increase']");
    private static final By DECREASE_ADULT_BUTTON = By.xpath("//button[@aria-controls='adults'][@title='Decrease']");
    private static final By QUANTITY_CHILDREN_INPUT = By.xpath("//input[@id='children']");
    private static final By INCREASE_CHILD_BUTTON = By.xpath("//button[@aria-controls='children'][@title='Increase']");
    private static final By DECREASE_CHILD_BUTTON = By.xpath("//button[@aria-controls='children'][@title='Decrease']");
    private static final By DONE_BUTTON = By.xpath("//footer/button");
    private static final By SEARCH_HOTELS_BUTTON = By.xpath("//form[@id='search-controls']//button");

    public SkyScannerHomePage(WebDriver driver) {
        super(driver);
    }

    public SkyScannerHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        checkCaptchaOnPage(driver, LOGGER, CAPTCHA_ELEMENT);
        new WebDriverWait(driver, 10);
        return this;
    }

    public SkyScannerHomePage logIn(User user) {
        driver.findElement(LOG_IN_BUTTON).click();
        waitForElementLocatedBy(driver, NEXT_BUTTON);
        driver.findElement(CONTINUE_WITH_EMAIL_BUTTON).click();
        driver.findElement(EMAIL_FIELD).sendKeys(user.getEmail());
        waitForElementLocatedBy(driver, ACCOUNT_DETECTED_BUTTON).click();
        waitForElementLocatedBy(driver, PASSWORD_FIELD).sendKeys(user.getPassword());
        waitForElementLocatedBy(driver, SECOND_LOG_IN_BUTTON).click();
        waitForElementLocatedBy(driver, CLOSE_MODAL_LOGIN_WINDOW_BUTTON).click();
        checkCaptchaOnPage(driver, LOGGER, CAPTCHA_ELEMENT);
        return this;
    }

    // Click to tabs.
    public SkyScannerHomePage clickToHostelsTab() {
        waitForElementLocatedBy(driver, HOSTEL_TAB).click();
        LOGGER.info(("Clicked on HOSTEL_TAB"));
        return this;
    }

    public SkyScannerHomePage clickToFlightsTab() {
        waitForElementLocatedBy(driver, FLIGHTS_TAB).click();
        LOGGER.info(("Clicked on FLIGHTS_TAB"));
        return this;
    }

    public SkyScannerHomePage clickToCarHireTab() {
        waitForElementLocatedBy(driver, CAR_HIRE_TAB).click();
        LOGGER.info(("Clicked on CAR_HIRE_TAB"));
        return this;
    }

    // Methods for Hotel tab elements.
    public SkyScannerHomePage addDestination(String destination) {
        waitForElementLocatedBy(driver, DESTINATION_OR_HOSTEL_NAME_INPUT).click();
        waitForElementLocatedBy(driver, DESTINATION_OR_HOSTEL_NAME_INPUT).sendKeys(destination);
        return this;
    }

    public SkyScannerHomePage increaseRoom() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        waitForElementLocatedBy(driver, INCREASE_ROOM_BUTTON).click();
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return this;
    }

    public SkyScannerHomePage increaseRoom(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseRoom();
        return this;
    }

    public SkyScannerHomePage increaseAdult() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        waitForElementLocatedBy(driver, INCREASE_ADULT_BUTTON).click();
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return this;
    }

    public SkyScannerHomePage increaseAdult(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseAdult();
        return this;
    }

    public SkyScannerHomePage increaseChild() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        waitForElementLocatedBy(driver, INCREASE_CHILD_BUTTON).click();
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return this;
    }

    public SkyScannerHomePage increaseChild(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseChild();
        return this;
    }

    public String getQuantityRooms() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        String quantity = waitForElementLocatedBy(driver, QUANTITY_ROOMS_INPUT).getAttribute("value");
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return quantity;
    }

    public String getQuantityAdultPeople() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        String quantity = waitForElementLocatedBy(driver, QUANTITY_ADULT_PEOPLE_INPUT).getAttribute("value");
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return quantity;
    }

    public String getQuantityChildren() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        String quantity = waitForElementLocatedBy(driver, QUANTITY_CHILDREN_INPUT).getAttribute("value");
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return quantity;
    }

    public SkyScannerHotelResultPage clickToSearchHotelsButton() {
        waitForElementLocatedBy(driver, SEARCH_HOTELS_BUTTON).click();
        return new SkyScannerHotelResultPage(driver);
    }

    public SkyScannerProfilePage openProfilePage() {
        waitForElementLocatedBy(driver, ACCOUNT_BUTTON).click();
        return new SkyScannerProfilePage(driver);
    }

    public String getTextFromFlightsButton() {
        return waitForElementLocatedBy(driver, SEARCH_FLIGHTS_BUTTON).getText();
    }

    public String getTextFromHotelButton() {
        return waitForElementLocatedBy(driver, SEARCH_HOTEL_BUTTON).getText();
    }

    public String getTextFromCarHeader() {
        return waitForElementLocatedBy(driver, CAR_HEADER).getText();
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }
}
