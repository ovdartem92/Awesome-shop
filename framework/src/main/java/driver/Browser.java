package driver;

import constants.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class Browser {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private Browser() {
    }

    public static WebDriver getDriver() {
        BrowserType type;
        if (DRIVER.get() == null) {
            if (System.getProperty("browser") != null)
                type = BrowserType.valueOf(System.getProperty("browser").toUpperCase());
            else type = BrowserType.CHROME;
            switch (type) {
                case FIREFOX: {
                    firefoxdriver().setup();
                    DRIVER.set(new FirefoxDriver());
                    configureDriver(DRIVER.get());
                    break;
                }
                case EDGE: {
                    edgedriver().setup();
                    DRIVER.set(new EdgeDriver());
                    configureDriver(DRIVER.get());
                    break;
                }
                case OPERA: {
                    operadriver().setup();
                    DRIVER.set(new OperaDriver());
                    configureDriver(DRIVER.get());
                    break;
                }
                case CHROME: {
                    chromedriver().setup();
                    DRIVER.set(new ChromeDriver());
                    configureDriver(DRIVER.get());
                    break;
                }
            }
        }
        return DRIVER.get();
    }

    private static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Constants.LONG_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
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

    public static void openPage(String str) {
        DRIVER.get().get(str);
    }

    public static void createNewTab(){
        JavascriptExecutor executor = (JavascriptExecutor)DRIVER.get();
        executor.executeScript("window.open();");
    }

    public static void switchTabByIndex(int index){
        ArrayList<String> tabs = new ArrayList<String> (Browser.getDriver().getWindowHandles());
        Browser.getDriver().switchTo().window(tabs.get(index));
    }
}
