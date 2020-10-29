package driver;

import service.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static utils.Captcha.checkCaptchaOnPage;

public class Browser {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final Logger LOGGER = LogManager.getRootLogger();
    public static final int SHORT_TIMEOUT_SECONDS = PropertiesReader.getIntegerProperty("stage", "timeout.short");
    public static final int LONG_TIMEOUT_SECONDS = PropertiesReader.getIntegerProperty("stage", "timeout.long");
    public static final int DEFAULT_TIMEOUT_SECONDS = PropertiesReader.getIntegerProperty("stage", "timeout.default");

    private Browser() {
    }

    public static WebDriver initDriver() {
        BrowserType type;
        if (getDriver() == null) {
            type = BrowserType.valueOf(System.getProperty("browser", PropertiesReader.getProperty("stage", "browser")).toUpperCase());
            switch (type) {
                case FIREFOX: {
                    firefoxdriver().setup();
                    DRIVER.set(new FirefoxDriver());
                    break;
                }
                case EDGE: {
                    edgedriver().setup();
                    DRIVER.set(new EdgeDriver());
                    break;
                }
                case OPERA: {
                    operadriver().setup();
                    DRIVER.set(new OperaDriver());
                    break;
                }
                case CHROME: {
                    chromedriver().setup();
                    DRIVER.set(new ChromeDriver());
                    break;
                }
            }
        }
        configureDriver(getDriver());
        return DRIVER.get();
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    private static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(LONG_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        for (String handle : DRIVER.get().getWindowHandles()) {
            DRIVER.get().switchTo().window(handle);
            DRIVER.get().close();
        }
        DRIVER.set(null);
    }

    enum BrowserType {
        CHROME("chrome"),
        FIREFOX("firefox"),
        EDGE("edge"),
        OPERA("opera");
        private String name;

        BrowserType(String name) {
            this.name = name;
        }
    }

    public static void openPage(String str) {
        DRIVER.get().get(str);
        checkCaptchaOnPage(LOGGER);
    }
}
