import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;
import utils.Constants;

public class HotelsSearchPageTest extends BaseTest {
    private final int MAX_ROOMS_QUANTITY = 5;
    private final int MAX_ADULT_PEOPLE_QUANTITY = 10;
    private final int MAX_CHILDREN_QUANTITY = 5;

    @Test
    public void checkMaximumValuesOfFilterButtons() {
        int roomsQuantityClicks = 4;
        int childrenQuantityClicks = 5;
        int adultQuantityClicks = 5;

        HeaderScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        HotelsSearchScreen searchHotelScreen = new HeaderScreen().clickHotelButton();
        searchHotelScreen.filterButtons.clickAddRoomButton(roomsQuantityClicks);
        searchHotelScreen.filterButtons.clickAddAdultButton(adultQuantityClicks);
        searchHotelScreen.filterButtons.clickAddChildButton(childrenQuantityClicks);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityRoomsInput(), MAX_ROOMS_QUANTITY);
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityAdultPeopleInput(), MAX_ADULT_PEOPLE_QUANTITY);
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityChildrenInput(), MAX_CHILDREN_QUANTITY);
    }
}
