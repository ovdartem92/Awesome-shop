import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;
import pages.net.skyscanner.hotels.source.FilterButtonsScreen.Title;
import pages.net.skyscanner.hotels.source.FilterButtonsScreen.Id;

public class HotelsSearchPageTest extends BaseTest {
    private final int MAX_ROOMS_QUANTITY = 5;
    private final int MAX_ADULT_PEOPLE_QUANTITY = 10;
    private final int MAX_CHILDREN_QUANTITY = 5;

    @Test(description = "check maximum filter values for hotel booking")
    public void checkMaximumValuesOfFilterButtons() {
        int roomsQuantityClicks = 4;
        int childrenQuantityClicks = 5;
        int adultQuantityClicks = 5;

        HotelsSearchScreen searchHotelScreen = new HeaderScreen().clickHotelButton();
        searchHotelScreen.filterButtons.clickButton(Title.INCREASE, Id.ROOMS, roomsQuantityClicks);
        searchHotelScreen.filterButtons.clickButton(Title.INCREASE, Id.ADULTS, adultQuantityClicks);
        searchHotelScreen.filterButtons.clickButton(Title.INCREASE, Id.CHILDREN, childrenQuantityClicks);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(Id.ROOMS), MAX_ROOMS_QUANTITY);
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(Id.ADULTS), MAX_ADULT_PEOPLE_QUANTITY);
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(Id.CHILDREN), MAX_CHILDREN_QUANTITY);
    }
}
