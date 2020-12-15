import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.listeners.SuiteListener;
import ru.awesome.shop.ta.framework.listeners.TestListener;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class, SuiteListener.class})
public abstract class BaseTest {
    protected final Browser browser = Browser.getInstance();

    @BeforeClass()
    public void setUp() {
        browser.navigate("https://awesome-shop.01sh.ru/");
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        browser.stop();
    }
}

