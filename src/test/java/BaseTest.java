import driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.net.skyscanner.elements.CaptchaScreen;
import service.TestDataReader;
import utils.TestListener;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected final String URL = TestDataReader.getTestData("testData.home.url");

    @BeforeMethod()
    public void setUp() {
        driver = Browser.initDriver();
        Browser.openPage(URL);
        CaptchaScreen.checkCaptchaOnPage();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        Browser.closeDriver();
    }
}
