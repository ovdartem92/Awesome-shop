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
import static util.Waiter.waitForElementToBeClickable;

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
    private static final By HOTEL_TAB = By.xpath("//nav[@id='PrimaryNav']//span[contains(text(), 'Hotels')]");
    private static final By CAR_HIRE_TAB = By.xpath("//a[@id='carhi']");
    private static final By CAR_HEADER = By.xpath("//div[@class='SearchControls_search-controls-title__27T3N']");
    private static final By SEARCH_FLIGHTS_BUTTON = By.xpath("//button[text()='Search flights']");

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
    public SkyScannerSearchHotelPage clickToHostelsTab() {
        waitForElementLocatedBy(driver, HOTEL_TAB).click();
        LOGGER.info(("Clicked on HOSTEL_TAB"));
        return new SkyScannerSearchHotelPage(driver);
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

    public SkyScannerFlightsResultsPage startFlightsSearch() {
        waitForElementToBeClickable(driver, SEARCH_FLIGHTS_BUTTON);
        driver.findElement(SEARCH_FLIGHTS_BUTTON).click();
        return new SkyScannerFlightsResultsPage(driver);
    }

    public SkyScannerProfilePage openProfilePage() {
        waitForElementLocatedBy(driver, ACCOUNT_BUTTON).click();
        return new SkyScannerProfilePage(driver);
    }

    public String getTextFromFlightsButton() {
        return waitForElementLocatedBy(driver, SEARCH_FLIGHTS_BUTTON).getText();
    }

    public String getTextFromCarHeader() {
        return waitForElementLocatedBy(driver, CAR_HEADER).getText();
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }
}
