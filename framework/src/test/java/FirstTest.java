import driver.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.SkyScannerHomePage;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), SkyScannerHomePage.getHomepageUrl(), "Url isn't correct");
    }
}
