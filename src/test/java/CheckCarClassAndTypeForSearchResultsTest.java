import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import service.CarSearchService;
import utils.Constants;

import java.util.List;

public class CheckCarClassAndTypeForSearchResultsTest extends BaseTest {
    String carClass = Constants.ECONOMY_CLASS_CAR;
    String carType = Constants.FOUR_DOOR_TYPE_CAR;
    List<String> listResultsCarClassType;

    @BeforeClass(description = "click on car button, set up location, click search, click car and type checkboxes")
    public void navigateToCarSearchScreenAndFindCarUsingData() {
        listResultsCarClassType = new CarSearchService().getCarClassTypeInfoFromSearchResults(Constants.MOSCOW_VNUKOVO_VKO, carClass, carType);
    }

    @Test(description = "check car class and type, which set on checkboxes are equals car class and type from Search result group panel")
    public void checkingPickupAndDropOffLocations() {
        SoftAssert softAssert = new SoftAssert();
        for (String value : listResultsCarClassType) {
            softAssert.assertTrue(value.contains(carClass), "Set car Class is not equals car Class info from search result Group Panel");
            softAssert.assertTrue(value.contains(carType), "Set car Type is not equals car Type info from search result Group Panel");
        }
        softAssert.assertAll();
    }
}
