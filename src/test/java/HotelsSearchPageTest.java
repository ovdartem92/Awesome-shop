import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;

import static service.HotelSearchService.Id.*;

public class HotelsSearchPageTest extends BaseTest {
    private final int MAX_ROOMS_QUANTITY = 5;
    private final int MAX_ADULT_PEOPLE_QUANTITY = 10;
    private final int MAX_CHILDREN_QUANTITY = 5;

    @Test(description = "check maximum filter values for hotel booking")
    public void checkMaximumValuesOfFilterButtons() {
        HotelsSearchScreen searchHotelScreen = new HeaderScreen().clickHotelButton();
        searchHotelScreen.filterButtons.maxClickButton(ROOMS);
        searchHotelScreen.filterButtons.maxClickButton(ADULTS);
        searchHotelScreen.filterButtons.maxClickButton(CHILDREN);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(ROOMS), MAX_ROOMS_QUANTITY);
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(ADULTS), MAX_ADULT_PEOPLE_QUANTITY);
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(CHILDREN), MAX_CHILDREN_QUANTITY);
    }
}
