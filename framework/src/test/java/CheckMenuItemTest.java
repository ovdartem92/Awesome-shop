import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerSearchHotelPage;

public class CheckMenuItemTest extends BaseTest {

    @Test
    public void checkMenuItems() {
        softAssert.assertEquals(new SkyScannerHomePage().clickToFlightsTab().getTextFromFlightsButton(), "Search flights");
        softAssert.assertEquals(new SkyScannerHomePage().clickToHostelsTab().getTextFromHotelButton(), "Search hotels ");
        softAssert.assertEquals(new SkyScannerSearchHotelPage().clickToCarHireTab().getTextFromCarHeader(), "Find your ride");
        softAssert.assertAll();
    }
}
