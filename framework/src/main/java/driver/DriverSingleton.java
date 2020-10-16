package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "edge": {
                    edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                default: {
                    chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();
        }
        driver = null;
    }
}

