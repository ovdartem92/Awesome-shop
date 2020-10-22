import driver.Browser;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import page.net.skyscanner.SkyScannerHomePage;
import util.TestListener;
import org.apache.logging.log4j.Logger;

import static util.CaptchaMethod.checkCaptchaOnPage;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected User user;
    private Logger LOGGER = LogManager.getRootLogger();

    @BeforeMethod()
    public void setUp() {
        driver = Browser.getDriver();
        new SkyScannerHomePage()
                .openPage();
        checkCaptchaOnPage(LOGGER);
        new SkyScannerHomePage().switchToEnglish();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        Browser.closeDriver();
    }
}
