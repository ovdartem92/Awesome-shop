import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;

public class CheckFirstTest extends BaseTest {

    @Test
    public void ourFirstTest() {
        new SkyScannerHomePage()
                .clickToFlightsTab();
        Assert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }
}
