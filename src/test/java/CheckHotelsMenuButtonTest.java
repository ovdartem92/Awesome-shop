import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AbstractScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;
import utils.Constants;

public class CheckHotelsMenuButtonTest extends BaseTest {
    HotelsSearchScreen hotelsSearchScreen;

    @BeforeMethod(description = "Change language, click on hotels button")
    public void navigateToHotelSearchPage() {
        hotelsSearchScreen = AbstractScreen.header.clickHotelButton();
    }

    @Test(description = "check that hotels menu button leads to the hotels search page")
    public void checkHotelsMenuButton() {
        Assert.assertTrue(hotelsSearchScreen.getTextFromHotelsSearchButton().contains(Constants.TEXT_ON_HOTEL_SEARCH_PAGE),
                "hotels menu button doesn't lead to the hotels search page");
    }
}
