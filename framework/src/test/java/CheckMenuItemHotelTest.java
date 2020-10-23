import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

public class CheckMenuItemHotelTest extends BaseTest {

    @Test
    public void checkMenuItems() {
        Assert.assertEquals(new SkyScannerHomePage().getHeader().clickToHostelsTab().getTextFromHotelButton(), "Search hotels ");
    }
}
