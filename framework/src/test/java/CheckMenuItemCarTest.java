import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

import static org.testng.Assert.assertEquals;

public class CheckMenuItemCarTest extends BaseTest {

    @Test
    public void checkMenuItemsHotel() {
        assertEquals(new SkyScannerHomePage().getHeader().clickToCarHireTab().getTextFromCarHeader(), "Find your ride");
    }
}
