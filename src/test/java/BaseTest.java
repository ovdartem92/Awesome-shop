import net.skyscanner.ta.framework.browser.Browser;
import net.skyscanner.ta.framework.listeners.SuiteListener;
import net.skyscanner.ta.framework.listeners.TestListener;
import net.skyscanner.ta.utils.TestDataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

/**
 * The class is a super class for all tests classes.
 * The class provides the configuration of browser and preconditions for each tests.
 */
@Listeners({TestListener.class, SuiteListener.class})
public abstract class BaseTest {
    protected final Browser browser = Browser.getInstance();
    protected final String URL = TestDataReader.getStageData("home.url");

    /**
     * The method executes before the first method of the current test class.
     */
    @BeforeClass()
    public void setUp() {
        browser.navigate(URL);
    }

    /**
     * The method executes after the last method of the current test class and allows to close current browser.
     */
    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        browser.stop();
    }
}

