import driver.DriverSingleton;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected User user;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        new SkyScannerHomePage(driver).openPage();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
