import driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.net.skyscanner.elements.CaptchaScreen;
import service.CultureService;
import service.TestDataReader;
import utils.Constants;
import utils.TestListener;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected final String URL = TestDataReader.getTestData("testData.home.url");

    @BeforeTest()
    public void setUp() {
        driver = Browser.initDriver();
        Browser.openPage(URL);
        CaptchaScreen.checkCaptchaOnPage();
        new CultureService().changeLanguage(Constants.ENGLISH_LANGUAGE);
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
        Browser.closeDriver();
    }
}
