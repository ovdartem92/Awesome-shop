import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen.FilterButtonsId;

public class HotelsSearchPageTest extends BaseTest {
    final int MAX_ROOMS_QUANTITY = 5;
    final int MAX_ADULT_PEOPLE_QUANTITY = 10;
    final int MAX_CHILDREN_QUANTITY = 5;
    HotelsSearchScreen hotelsSearchScreen;

    @BeforeClass(description = "click on hotels button")
    public void navigateToHotelsSearchPage() {
        hotelsSearchScreen = HeaderScreen.header.clickHotelButton();
    }

    @Test(description = "check maximum filter values for hotel booking")
    public void checkMaximumValuesOfFilterButtons() {
        for (FilterButtonsId id : FilterButtonsId.values())
            hotelsSearchScreen.clickMaxIncreaseFilterButton(id);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(hotelsSearchScreen.getQuantityOfFilterInput(FilterButtonsId.ROOMS), MAX_ROOMS_QUANTITY,
                "The number of rooms does not match the specified value");
        softAssert.assertEquals(hotelsSearchScreen.getQuantityOfFilterInput(FilterButtonsId.ADULTS), MAX_ADULT_PEOPLE_QUANTITY,
                "The number of adults does not match the specified value");
        softAssert.assertEquals(hotelsSearchScreen.getQuantityOfFilterInput(FilterButtonsId.CHILDREN), MAX_CHILDREN_QUANTITY,
                "The number of children does not match the specified value");
        softAssert.assertAll();
    }
}
