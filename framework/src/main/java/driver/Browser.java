package driver;

import constants.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class Browser {

    private static WebDriver driver;

    private Browser() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    configureDriver(driver);
                    break;
                }
                case "edge": {
                    edgedriver().setup();
                    driver = new EdgeDriver();
                    configureDriver(driver);
                    break;
                }
                default: {
                    chromedriver().setup();
                    driver = new ChromeDriver();
                    configureDriver(driver);
                    break;
                }
            }
            driver.manage().window().maximize();
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

