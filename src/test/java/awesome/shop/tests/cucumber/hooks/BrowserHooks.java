package awesome.shop.tests.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.framework.logging.Log;

import java.io.File;
import java.util.Objects;

public class BrowserHooks {
    protected Browser browser;

    @Before
    public void setUp() {
        browser = Browser.getInstance();
        browser.navigate(PropertyManager.getUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        Objects.requireNonNull(scenario, "iTestResult cannot be null.");
        if (scenario.isFailed()) {
            File screenshot = browser.takeScreenshot();
            String screenshotTag = String.format("<a href='../../screenshots/%s'><img src='../../screenshots/%s' "
                    + "height='304' width='525'/></a>", screenshot.getName(), screenshot.getName());
            Log.info(String.format("Screenshot %s was saved", screenshotTag));
            byte[] screenshotForReport = ((TakesScreenshot) browser.getWrappedDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotForReport, "image/png", scenario.getName());
        }
        browser.stop();
    }
}
