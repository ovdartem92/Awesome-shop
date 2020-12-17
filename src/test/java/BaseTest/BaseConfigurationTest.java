package BaseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.listeners.SuiteListener;
import ru.awesome.shop.ta.framework.listeners.TestListener;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class, SuiteListener.class})
public abstract class BaseConfigurationTest {
    private Browser browser = Browser.getInstance();

    @BeforeMethod(description = "Set Up", groups = {"all", "positive", "negative"})
    public void setUp() {
        browser.navigate("https://awesome-shop.01sh.ru/");
    }

    @AfterMethod(description = "Tear Down", groups = {"all", "positive", "negative"})
    public void tearDown() {
        browser.stop();
    }
}

