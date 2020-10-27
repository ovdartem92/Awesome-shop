import driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.AbstractPage;
import utils.TestListener;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = Browser.getDriver();
        Browser.openPage(AbstractPage.getHomepageUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        Browser.closeDriver();
    }
}
