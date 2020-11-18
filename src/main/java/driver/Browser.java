package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import service.TestDataReader;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static final int SHORT_TIMEOUT_SECONDS = TestDataReader.getIntStageData("timeout.short");
    public static final int LONG_TIMEOUT_SECONDS = TestDataReader.getIntStageData("timeout.long");
    public static final int DEFAULT_TIMEOUT_SECONDS = TestDataReader.getIntStageData("timeout.default");
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private Browser() {
    }

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

    private static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(LONG_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
            getDriver().close();
        }
        DRIVER.remove();
    }

    public static void openPage(String url) {
        getDriver().get(url);
    }

    enum BrowserType {
        CHROME(),
        FIREFOX(),
        EDGE(),
        OPERA()
    }
}
