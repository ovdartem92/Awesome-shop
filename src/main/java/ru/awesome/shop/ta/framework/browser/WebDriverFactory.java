package ru.awesome.shop.ta.framework.browser;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.awesome.shop.ta.framework.listeners.WebDriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.awesome.shop.ta.framework.logging.Log;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public final class WebDriverFactory {

    private WebDriverFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", WebDriverFactory.class));
    }

    public static WebDriver getWebDriver(BrowserType type) {
        WebDriver webDriver = null;
        try {
            switch (type) {
                case FIREFOX:
                    webDriver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
                    break;
                case CHROME:
                    webDriver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
                    break;
                default:
                    throw new IllegalArgumentException(format("Unexpected browser type: %s", type));
            }
        } catch (MalformedURLException e) {
            Log.info(e.getMessage());
        }
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.register(new WebDriverListener());
        eventFiringWebDriver.manage().window().maximize();
        return eventFiringWebDriver;
    }
}
