package awesome.shop.tests.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;

public class BrowserHooks {
    protected Browser browser;

    @Before
    public void setUp() {
        browser = Browser.getInstance();
        browser.navigate(PropertyManager.getUrl());
    }

    @After
    public void tearDown() {
        browser.stop();
    }
}
