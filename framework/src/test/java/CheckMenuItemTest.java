import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerSearchHotelPage;

public class CheckMenuItemTest extends BaseTest {

    @Test
    public void checkMenuItems() {
        Assert.assertEquals(new SkyScannerHomePage().clickToFlightsTab().getTextFromFlightsButton(), "Search flights");
        Assert.assertEquals(new SkyScannerHomePage().clickToHostelsTab().getTextFromHotelButton(), "Search hotels ");
        Assert.assertEquals(new SkyScannerSearchHotelPage().clickToCarHireTab().getTextFromCarHeader(), "Find your ride");
    }
}
