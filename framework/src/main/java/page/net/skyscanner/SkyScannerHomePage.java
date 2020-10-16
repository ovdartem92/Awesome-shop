package page.net.skyscanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

import static util.Util.waitForElementLocatedBy;

public class SkyScannerHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.skyscanner.net/";
    private WebElement element;
    private static final By logInButton = By.id("authentication-link");
    private static final By emailField = By.id("email");
    private static final By nextButton = By.id("login-modal");
    private static final By passwordField = By.id("password");
    private static final By continueWithEmailButton = By.xpath("//button[@data-testid='login-email-button']");
    private static final By accountDetectionButton = By.xpath("//button[@data-testid='account-detection-button']");
    private static final By loginButton2 = By.xpath("//button[@data-testid='login-button']");
    private static final By closeButton = By.xpath("//button[@data-testid='modal-close-button']");
    private static final By wrongEmailOrPasswordTable = By.xpath("//span[text()='Wrong email or password']");

    // Tab WebElements.
    private static final By flightsTab = By.xpath("//nav[@id='PrimaryNav']//span[contains(text(), 'Flights')]");
    private static final By hostelTab = By.xpath("//nav[@id='PrimaryNav']//span[contains(text(), 'Hotels')]");
    private static final By carHireTab = By.xpath("//nav[@id='PrimaryNav']//span[contains(text(), 'Car Hire')]");

    // Hotels WebElements.
    private static final By destinationOrHostelNameInput = By.xpath("//input[@name='destination-autosuggest']");
    private static final By hostelCheckInInput = By.xpath("//input[@id='checkin']");
    private static final By hostelCheckOutInput = By.xpath("//input[@id='checkout']");
    private static final By guestsAndRoomsInput = By.xpath("//input[@id='guests-rooms']");
    private static final By searchButton = By.xpath("//button[contains(text(), 'Search hotels')]");

    // Hotels guests and rooms WebElements.
    private static final By quantityRoomsInput = By.xpath("//input[@id='rooms']");
    private static final By increaseRoomButton = By.xpath("//button[@aria-controls='rooms'][@title='Increase']");
    private static final By decreaseRoomButton = By.xpath("//button[@aria-controls='rooms'][@title='Decrease']");
    private static final By quantityAdultPeopleInput = By.xpath("//input[@id='adults']");
    private static final By increaseAdultButton = By.xpath("//button[@aria-controls='adults'][@title='Increase']");
    private static final By decreaseAdultButton = By.xpath("//button[@aria-controls='adults'][@title='Decrease']");
    private static final By quantityChildrenInput = By.xpath("//input[@id='children']");
    private static final By increaseChildButton = By.xpath("//button[@aria-controls='children'][@title='Increase']");
    private static final By decreaseChildButton = By.xpath("//button[@aria-controls='children'][@title='Decrease']");
    private static final By doneButton = By.xpath("//footer/button");

    public SkyScannerHomePage(WebDriver driver) {
        super(driver);
    }

    public SkyScannerHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public SkyScannerHomePage clickOnLogIn() {
        element = driver.findElement(logInButton);
        element.click();
        waitForElementLocatedBy(driver, nextButton);
        return this;
    }

    public SkyScannerHomePage clickOnContinueWithEmail() {
        element = driver.findElement(continueWithEmailButton);
        element.click();
        return this;
    }

    public SkyScannerHomePage enterEmail(String txt) {
        element = driver.findElement(emailField);
        element.sendKeys(txt);
        waitForElementLocatedBy(driver, accountDetectionButton);
        element = driver.findElement(accountDetectionButton);
        element.click();
        return this;
    }

    public SkyScannerHomePage enterPassword(String txt) {
        waitForElementLocatedBy(driver, passwordField);
        element = driver.findElement(passwordField);
        element.sendKeys(txt);
        waitForElementLocatedBy(driver, loginButton2);
        element = driver.findElement(loginButton2);
        element.click();
        return this;
    }

    public SkyScannerHomePage closeModal() {
        waitForElementLocatedBy(driver, closeButton);
        element = driver.findElement(closeButton);
        element.click();
        return this;
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }
}
