import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;

public class CheckMenuItemTest extends CommonConditions {
    @Test
    public void checkMenuItems() {
        SkyScannerHomePage skyScannerHomePage = new SkyScannerHomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(skyScannerHomePage.clickToFlightsTab().getTextFromFlightsButton(), "Search flights");
        softAssert.assertEquals(skyScannerHomePage.clickToHostelsTab().getTextFromHotelButton(), "Search hotels ");
        softAssert.assertEquals(skyScannerHomePage.clickToCarHireTab().getTextFromCarHeader(), "Find your ride");
        softAssert.assertAll();
    }
}
