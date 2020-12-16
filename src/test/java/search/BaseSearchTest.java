package search;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.listeners.SuiteListener;
import ru.awesome.shop.ta.framework.listeners.TestListener;
import ru.awesome.shop.ta.product.pages.Header;
import ru.awesome.shop.ta.product.pages.SearchPage;
import ru.awesome.shop.ta.utils.TestDataReader;

/**
 * The class is a super class for all tests classes.
 * The class provides the configuration of browser and preconditions for each tests.
 */
@Listeners({TestListener.class, SuiteListener.class})
public abstract class BaseSearchTest {
    protected SearchPage searchPage;
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
    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
        browser.stop();
    }
}
