import driver.Browser;
import net.skyscanner.ta.framework.listeners.SuiteListener;
import net.skyscanner.ta.framework.listeners.TestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.net.skyscanner.elements.CaptchaScreen;
import service.CultureService;
import service.TestDataReader;
import utils.Constants;

/**
 * The class is a super class for all tests classes.
 * The class provides the configuration of browser and preconditions for each tests.
 */
@Listeners({TestListener.class, SuiteListener.class})
public abstract class BaseTest {
    /**
     * The variable is SkyScanner home page URL. It get value from stage.properties file.
     * <a href="file:src/main/resources/stage.properties">/resources/stage.properties</a>
     */
    private final String URL = TestDataReader.getStageData("home.url");

    /**
     * The method executes before the first method of the current test class.
     * The method provide configuration of browser, opening SkyScanner home page,
     * checking that CAPTCHA doesn't appear on SkyScanner home page, setting language as English.
     */
    @BeforeClass()
    public void setUp() {
        Browser.initDriver();
        Browser.openPage(URL);
        CaptchaScreen.checkCaptchaOnPage();
        new CultureService().changeLanguage(Constants.ENGLISH_LANGUAGE);
    }

    /**
     * The method executes after the last method of the current test class and allows to close current browser.
     */
    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        Browser.closeDriver();
    }
}
