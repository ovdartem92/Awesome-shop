package awesome.shop.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import ru.awesome.shop.ta.framework.browser.Browser;

public abstract class BaseConfigurationTest {
    private Browser browser;

    @BeforeMethod(description = "Set Up", groups = {"all", "positive", "negative"})
    public void setUp() {
        browser = Browser.getInstance();
    }

    @AfterMethod(description = "Tear Down", groups = {"all", "positive", "negative"})
    public void tearDown() {
        browser.stop();
    }
}
