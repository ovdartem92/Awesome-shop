package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import service.TestDataReader;

import java.util.concurrent.TimeUnit;

/**
 * This class uses the Singleton pattern.
 * It is needed to init driver or get driver and we have ability to chose browser and open some link.
 */
public class Browser {
    /**
     * These variables get data from the property file, they need to set up timeouts.
     */
    public static final int SHORT_TIMEOUT_SECONDS = TestDataReader.getIntStageData("timeout.short");
    public static final int LONG_TIMEOUT_SECONDS = TestDataReader.getIntStageData("timeout.long");
    public static final int DEFAULT_TIMEOUT_SECONDS = TestDataReader.getIntStageData("timeout.default");
    /**
     * This variable stores instances of WebDriver, it is required for parallel tests.
     */
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    /**
     * The private constructor is needed because we don't create any instance of this class.
     */
    private Browser() {
    }

    /**
     * This is the main method in our class, it is needed to check ability a WebDriver instance has been created,
     * if not, we create a new instance, if it has already been created, then we return it and do not create anything.
     *
     * @return instance of browser
     */
    public static WebDriver initDriver() {
        BrowserType type;
        if (getDriver() == null) {
            type = BrowserType.valueOf(System.getProperty("browser", TestDataReader.getStageData("browser")).toUpperCase());
            switch (type) {
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    DRIVER.set(new FirefoxDriver());
                    break;
                }
                case EDGE: {
                    WebDriverManager.edgedriver().setup();
                    DRIVER.set(new EdgeDriver());
                    break;
                }
                case OPERA: {
                    WebDriverManager.operadriver().setup();
                    DRIVER.set(new OperaDriver());
                    break;
                }
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    DRIVER.set(new ChromeDriver());
                    break;
                }
            }
        }
        configureDriver(getDriver());
        return getDriver();
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    /**
     * This method configures timeouts and opens the window to full screen mode.
     *
     * @param driver set your own timeouts for an already created instance
     */
    private static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(LONG_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * This method checks if there are open windows in the browser and then closes them and deletes the driver instance.
     */
    public static void closeDriver() {
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
            getDriver().close();
        }
        DRIVER.remove();
    }

    /**
     * This method lets us open the link in the browser.
     *
     * @param url address of the page you would like to open
     */
    public static void openPage(String url) {
        getDriver().get(url);
    }

    /**
     * This enum stores browsers that we support.
     */
    enum BrowserType {
        CHROME(),
        FIREFOX(),
        EDGE(),
        OPERA()
    }
}
