package awesome.shop.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.listeners.SuiteListener;
import ru.awesome.shop.ta.framework.listeners.TestListener;

@Listeners({TestListener.class, SuiteListener.class})
public abstract class BaseConfigurationTest {
    protected Browser browser;

    @BeforeMethod(description = "Set Up", groups = {"all", "positive", "negative"})
    public void setUp() {
        browser = Browser.getInstance();
    }

    @AfterMethod(description = "Tear Down", groups = {"all", "positive", "negative"})
    public void tearDown() {
        browser.stop();
    }
}
