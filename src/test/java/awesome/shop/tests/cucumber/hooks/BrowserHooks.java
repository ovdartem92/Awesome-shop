package awesome.shop.tests.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.awesome.shop.ta.framework.browser.Browser;

public class BrowserHooks {
    protected Browser browser;

    @Before
    public void setUp() {
        browser = Browser.getInstance();
    }

    @After
    public void tearDown() {
        browser.stop();
    }
}
