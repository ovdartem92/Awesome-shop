import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

import static org.testng.Assert.assertEquals;

public class CheckMenuItemFlightsTest extends BaseTest {

    @Test
    public void checkMenuItemsFlights() {
        assertEquals(new SkyScannerHomePage().clickToFlightsTab().getTextFromFlightsButton(), "Search flights");
    }
}
