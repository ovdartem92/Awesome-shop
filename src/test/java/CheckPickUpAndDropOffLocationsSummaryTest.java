import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.cars.car_service.CarSearchService;
import utils.Constants;

public class CheckPickUpAndDropOffLocationsSummaryTest extends BaseTest {
    private final String pickUpLocation = Constants.MOSCOW_SHEREMETYEVO_SVO;
    private final String dropOffLocation = Constants.MOSCOW_VNUKOVO_VKO;
    private CarsSearchResultsScreen carsSearchResultsScreen;

    @BeforeClass(description = "Click on car button, set up locations and click search")
    public void navigateToCarSearchScreenAndFindCarUsingData() {
        carsSearchResultsScreen = new CarSearchService().searchCarUsingLocationsData(pickUpLocation, dropOffLocation);
    }

    @Test(description = "check input values of locations are equals locations in search result page summary")
    public void checkingPickupAndDropOffLocations() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pickUpLocation, carsSearchResultsScreen.getInfoAboutPickUpLocationFromSummary(),
                "Input set up location is not equals summary set up location.");
        softAssert.assertEquals(dropOffLocation, carsSearchResultsScreen.getInfoAboutDropOffLocationFromSummary(),
                "Input drop off location is not equals summary drop off location.");
        softAssert.assertAll();
    }
}
