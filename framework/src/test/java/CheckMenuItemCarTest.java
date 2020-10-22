import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

import static org.testng.Assert.assertEquals;

public class CheckMenuItemCarTest {

    @Test
    public void checkMenuItemsHotel() {
        assertEquals(new SkyScannerHomePage().clickToCarHireTab().getTextFromCarHeader(), "Find your ride");
    }
}
