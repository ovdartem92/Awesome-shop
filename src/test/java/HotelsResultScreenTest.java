import model.Hotel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AbstractScreen;
import pages.net.skyscanner.hotels.HotelsResultScreen;
import utils.Constants;

import java.util.List;

public class HotelsResultScreenTest extends BaseTest {
    HotelsResultScreen hotelsResultScreen;

    @BeforeClass(description = "click on hotels button")
    public void navigateToHotelsSearchPage() {
        hotelsResultScreen = AbstractScreen.header.clickHotelButton()
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
}
