package net.skyscanner.ta.framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public final class WebDriverFactory {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", WebDriverFactory.class));
    }

    public static WebDriver getWebDriver(BrowserType type) {
        if (webDriverThreadLocal.get() == null) {
            switch (type) {
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    webDriverThreadLocal.set(new FirefoxDriver());
                    break;
                }
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    webDriverThreadLocal.set(new ChromeDriver());
                    break;
                }
                default:
                    throw new IllegalArgumentException(format("Unexpected browser type: %s", type));
            }
        }
        configureWebDriver(webDriverThreadLocal.get());
        return webDriverThreadLocal.get();
    }

    private static void configureWebDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeWebDriver() {
        webDriverThreadLocal.remove();
    }
}
