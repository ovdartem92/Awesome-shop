import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;
import pages.net.skyscanner.hotels.source.FilterButtonsScreen;

import static pages.net.skyscanner.hotels.source.FilterButtonsScreen.Id.*;

public class HotelsSearchPageTest extends BaseTest {
    private final int MAX_ROOMS_QUANTITY = 5;
    private final int MAX_ADULT_PEOPLE_QUANTITY = 10;
    private final int MAX_CHILDREN_QUANTITY = 5;

    @Test(description = "check maximum filter values for hotel booking")
    public void checkMaximumValuesOfFilterButtons() {
        SoftAssert softAssert = new SoftAssert();
        HotelsSearchScreen searchHotelScreen = new HeaderScreen().clickHotelButton();
        for (FilterButtonsScreen.Id id : FilterButtonsScreen.Id.values())
            searchHotelScreen.filterButtons.maxClickButton(id);

        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(ROOMS), MAX_ROOMS_QUANTITY,
                "The number of rooms does not match the specified value.");
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(ADULTS), MAX_ADULT_PEOPLE_QUANTITY,
                "The number of adults does not match the specified value.");
        softAssert.assertEquals(searchHotelScreen.filterButtons.getQuantityInput(CHILDREN), MAX_CHILDREN_QUANTITY,
                "The number of children does not match the specified value.");
    }
}
