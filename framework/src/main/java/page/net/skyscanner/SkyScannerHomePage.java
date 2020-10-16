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
