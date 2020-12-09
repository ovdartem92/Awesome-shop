package net.skyscanner.ta.framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.skyscanner.ta.framework.listeners.WebDriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static java.lang.String.format;

public final class WebDriverFactory {

    private WebDriverFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", WebDriverFactory.class));
    }

    public static WebDriver getWebDriver(BrowserType type) {
        WebDriver webDriver;
        switch (type) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException(format("Unexpected browser type: %s", type));
        }
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.register(new WebDriverListener());
        eventFiringWebDriver.manage().window().maximize();
        return eventFiringWebDriver;
    }
}
