package awesome.shop.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseConfigurationGridDockerTest {
    protected WebDriver driver;

    @Parameters({"Port"})
    @BeforeMethod
    public void initiateDriver(String Port) throws MalformedURLException {
        if (Port.equalsIgnoreCase("9001")) {
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        } else if (Port.equalsIgnoreCase("9002")) {
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://awesome-shop.01sh.ru/index.php?route=account/login");
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }

}
