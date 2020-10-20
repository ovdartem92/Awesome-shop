package driver;

import constants.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class Browser {
    private static WebDriver driver;

    private Browser() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            if (System.getProperty("browser") != null) {
                BrowserType type = BrowserType.valueOf(System.getProperty("browser").toUpperCase());
                switch (type) {
                    case FIREFOX: {
                        firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        configureDriver(driver);
                        break;
                    }
                    case EDGE: {
                        edgedriver().setup();
                        driver = new EdgeDriver();
                        configureDriver(driver);
                        break;
                    }
                    case OPERA: {
                        operadriver().setup();
                        driver = new OperaDriver();
                        configureDriver(driver);
                        break;
                    }
                    case CHROME: {
                        chromedriver().setup();
                        driver = new ChromeDriver();
                        configureDriver(driver);
                        break;
                    }
                }
            } else {
                chromedriver().setup();
                driver = new ChromeDriver();
                configureDriver(driver);
            }
        }
        return driver;
    }

    private static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Timeout.LONG_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Timeout.DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();
        }
        driver = null;
    }
}

enum BrowserType {
    CHROME("chrome"), FIREFOX("firefox"),
    EDGE("edge"), OPERA("opera");
    private String name;

    BrowserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
