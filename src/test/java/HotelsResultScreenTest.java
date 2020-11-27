import model.Hotel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsResultScreen;
import utils.Constants;

import java.util.List;


public class HotelsResultScreenTest extends BaseTest {
    HotelsResultScreen hotelsResultScreen;

    @BeforeClass(description = "click on hotel button, set up locations and click search")
    public void navigateToHotelsSearchPage() {
        hotelsResultScreen = new HeaderScreen().clickHotelButton()
                .typeTextToDestinationInput(Constants.TURIN)
                .clickSearchHotelsButton();
    }

    @Test(description = "checking hotel sorting by rating")
    public void checkRatingSort() {
        hotelsResultScreen.clickToGuestRattingSortButton();
        List<Hotel> hotels = hotelsResultScreen.getHotels();
        Assert.assertTrue(hotelsResultScreen.isHotelSortedByRating(hotels),
                "the sorting of collection values by rating does not match");
    }

    @Test(description = "checking hotel sorting by price")
    public void checkPriceSort() {
        hotelsResultScreen.clickToPriceSortButton();
        List<Hotel> hotels = hotelsResultScreen.getHotels();
        Assert.assertTrue(hotelsResultScreen.isHotelSortedByPrice(hotels),
                "the sorting of collection values by price does not match");
    }
}
