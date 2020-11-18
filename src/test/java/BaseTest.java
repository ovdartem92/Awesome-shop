import driver.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.net.skyscanner.elements.CaptchaScreen;
import service.CultureService;
import service.TestDataReader;
import utils.Constants;
import utils.TestListener;

@Listeners({TestListener.class})
public abstract class BaseTest {
    private final String URL = TestDataReader.getTestData("testData.home.url", TestDataReader.getStageData("home.url"));

    @BeforeClass()
    public void setUp() {
        Browser.initDriver();
        Browser.openPage(URL);
        CaptchaScreen.checkCaptchaOnPage();
        new CultureService().changeLanguage(Constants.ENGLISH_LANGUAGE);
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        Browser.closeDriver();
    }
}
