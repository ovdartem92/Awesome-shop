import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import service.CarSearchService;
import utils.Constants;

import java.util.List;

public class CheckCarClassAndTypeForSearchResultsTest extends BaseTest {
    CarsSearchResultsScreen carsSearchResultsScreen;
    CarSearchService carSearchService = new CarSearchService();
    String pickUpLocation = Constants.MOSCOW_VNUKOVO_VKO;
    String carClass = Constants.ECONOMY_CLASS_CAR;
    String carType = Constants.FOUR_DOOR_TYPE_CAR;
    List<String> listResultsCarClassType;

    @BeforeClass(description = "click on car button, set up location, click search, click car and type checkboxes")
    public void navigateToCarSearchScreenAndFindCarUsingData() {
        carsSearchResultsScreen = carSearchService.searchCarUsingPickUpLocation(pickUpLocation);
        carSearchService.setCheckboxForCarClassAndType(carClass, carType);
        listResultsCarClassType = carsSearchResultsScreen.getListCarClassTypeFromGroupPanel();
    }

    @Test(description = "check car class and type, which set on checkboxes are equals car class and type from Search result group panel")
    public void checkingPickupAndDropOffLocations() {
        SoftAssert softAssert = new SoftAssert();
        for (String value : listResultsCarClassType) {
            softAssert.assertTrue(value.contains(carClass + "\n" + carType), "Set car Class/Type is not equals Car Class/Type info from Search result Group Panel");
        }
        softAssert.assertAll();
    }
}
