package awesome.shop.tests.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.framework.logging.Log;

import java.io.File;
import java.io.IOException;

public class BrowserHooks {
    protected Browser browser;

    @Before
    public void setUp() {
        browser = Browser.getInstance();
        browser.navigate(PropertyManager.getUrl());
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            Log.info(String.format("SCENARIO named: %s is FAILED!", scenario.getName()));
            File screenshot = browser.takeScreenshot();
            Log.info("SCREENSHOT was saved to: target/screenshots");
            byte[] screenshotByteArray = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(screenshotByteArray, "image/png", scenario.getName());
            Log.info("SCREENSHOT was attached to: target/cucumber-reports/cucumber-pretty.html");
        }
        browser.stop();
    }
}
