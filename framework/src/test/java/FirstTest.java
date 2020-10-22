import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

public class FirstTest extends BaseTest {

    @Test
    public void ourFirstTest() {
        new SkyScannerHomePage()
                .clickToFlightsTab();
        softAssert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }

    @Test
    public void ourSecondTest() {
        new SkyScannerHomePage()
                .clickToHostelsTab();
        softAssert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }

    @Test
    public void ourThirdTest() {
        new SkyScannerHomePage()
                .clickToCarHireTab();
        softAssert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }
}
