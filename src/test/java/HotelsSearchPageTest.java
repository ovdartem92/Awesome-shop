import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;

public class HotelsSearchPageTest extends BaseTest {
    @Test(description = "check maximum filter values for hotel booking")
    public void checkMaximumValuesOfFilterButtons() {
        int maxRoomsQuantity = 5;
        int maxAdultPeopleQuantity = 10;
        int maxChildrenQuantity = 5;
        SoftAssert softAssert = new SoftAssert();
        HotelsSearchScreen searchHotelScreen = new HeaderScreen().clickHotelButton();
        for (HotelsSearchScreen.Id id : HotelsSearchScreen.Id.values())
            searchHotelScreen.maxClickButton(id);

        softAssert.assertEquals(searchHotelScreen.getQuantityInput(HotelsSearchScreen.Id.ROOMS), maxRoomsQuantity,
                "The number of rooms does not match the specified value");
        softAssert.assertEquals(searchHotelScreen.getQuantityInput(HotelsSearchScreen.Id.ADULTS), maxAdultPeopleQuantity,
                "The number of adults does not match the specified value");
        softAssert.assertEquals(searchHotelScreen.getQuantityInput(HotelsSearchScreen.Id.CHILDREN), maxChildrenQuantity,
                "The number of children does not match the specified value");
        softAssert.assertAll();
    }
}
