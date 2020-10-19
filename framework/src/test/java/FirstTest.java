import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

public class FirstTest extends CommonConditions {

    @Test
    public void ourFirstTest() {
        new SkyScannerHomePage(driver)
                .openPage().clickToFlightsTab();
        softAssert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }

    @Test
    public void ourSecondTest() {
        new SkyScannerHomePage(driver)
                .openPage().clickToHostelsTab();
        softAssert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }

    @Test
    public void ourThirdTest() {
        new SkyScannerHomePage(driver)
                .openPage().clickToCarHireTab();
        softAssert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }
}
