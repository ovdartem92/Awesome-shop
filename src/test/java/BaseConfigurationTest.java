import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.listeners.SuiteListener;
import ru.awesome.shop.ta.framework.listeners.TestListener;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;
import ru.awesome.shop.ta.utils.TestDataReader;

import java.lang.reflect.Method;

/**
 * The class is a super class for all tests classes.
 * The class provides the configuration of browser and preconditions for each tests.
 */
@Listeners({TestListener.class, SuiteListener.class})
public abstract class BaseConfigurationTest {
    protected Browser browser;
    protected final String URL = TestDataReader.getStageData("home.url");

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

