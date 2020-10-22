import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

public class FirstTest extends BaseTest {

    @Test
    public void ourFirstTest() {
        new SkyScannerHomePage()
                .clickToFlightsTab();
        Assert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }
}
