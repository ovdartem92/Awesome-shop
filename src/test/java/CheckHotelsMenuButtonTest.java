import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;
import utils.Constants;

public class CheckHotelsMenuButtonTest extends BaseTest {
    HotelsSearchScreen hotelsSearchScreen;

    @BeforeClass(description = "Click on hotels button")
    public void navigateToHotelSearchPage() {
        hotelsSearchScreen = HeaderScreen.header.clickHotelButton();
    }

    @Test(description = "check that hotels menu button leads to the hotels search page")
    public void checkHotelsMenuButton() {
        Assert.assertTrue(hotelsSearchScreen.getTextFromHotelsSearchButton().contains(Constants.TEXT_ON_HOTEL_SEARCH_PAGE),
                "hotels menu button doesn't lead to the hotels search page");
    }
}
