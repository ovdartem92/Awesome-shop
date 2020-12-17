package awesome.shop.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.listeners.SuiteListener;
import ru.awesome.shop.ta.framework.listeners.TestListener;
import ru.awesome.shop.ta.product.pages.SearchResultPage;
import ru.awesome.shop.ta.utils.TestDataReader;

import java.lang.reflect.Method;

@Listeners({TestListener.class, SuiteListener.class})
public abstract class BaseSearchTest {
    protected final String URL = TestDataReader.getStageData("home.url");
    protected SearchResultPage searchPage;
    protected Browser browser;

    @BeforeMethod(description = "Set Up", groups = {"all", "positive", "negative"})
    public void setUp(Method method) {
        browser = Browser.getInstance();
        browser.navigate(URL);
    }

    @AfterMethod(description = "Tear Down", groups = {"all", "positive", "negative"})
    public void tearDown() {
        browser.stop();
    }
}
