import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;
import utils.Constants;

public class CheckMaximumValuesForHotelBookingTest extends BaseTest {
    private final int MAX_ROOMS_QUANTITY = 5;
    private final int MAX_ADULT_PEOPLE_QUANTITY = 10;
    private final int MAX_CHILDREN_QUANTITY = 5;

    @Test
    public void checkingMaximumValues() {
        int roomsQuantityClick = 4;
        int childrenQuantityClick = 5;
        int adultQuantityClick = 5;

        HeaderScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        HotelsSearchScreen searchHotelScreen = new HeaderScreen()
                .clickHotelButton()
                .addDestination(Constants.TURIN)
                .increaseRoom(roomsQuantityClick)
                .increaseAdult(childrenQuantityClick)
                .increaseChild(adultQuantityClick);

        Assert.assertEquals(searchHotelScreen.getQuantityRooms(), MAX_ROOMS_QUANTITY);
        Assert.assertEquals(searchHotelScreen.getQuantityAdultPeople(), MAX_ADULT_PEOPLE_QUANTITY);
        Assert.assertEquals(searchHotelScreen.getQuantityChildren(), MAX_CHILDREN_QUANTITY);
    }
}
