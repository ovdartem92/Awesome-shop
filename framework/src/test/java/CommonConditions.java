import driver.DriverSingleton;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import util.TestListener;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

import static util.CaptchaMethod.checkCaptchaOnPage;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected User user;
    protected SoftAssert softAssert = new SoftAssert();
    private Logger LOGGER = LogManager.getRootLogger();

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        new SkyScannerHomePage(driver).openPage();
        if(checkCaptchaOnPage(driver)) {
            LOGGER.info("Test was skipped, because captcha has appeared");
            throw new SkipException("Test" + "" + "was skipped, because captcha has appeared");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
