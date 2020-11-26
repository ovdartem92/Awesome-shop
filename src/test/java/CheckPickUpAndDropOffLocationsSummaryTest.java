import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import service.CarSearchService;
import utils.Constants;

public class CheckPickUpAndDropOffLocationsSummaryTest extends BaseTest {
    String pickUpLocation = Constants.MOSCOW_SHEREMETYEVO_SVO;
    String dropOffLocation = Constants.MOSCOW_VNUKOVO_VKO;

    @BeforeClass(description = "click on car button, set up locations and click search")
    public void navigateToCarSearchScreenAndFindCarUsingData() {
        new CarSearchService().searchCarUsingLocationsData(pickUpLocation, dropOffLocation);
    }

    @Test(description = "check input values of locations are equals locations in search result page summary")
    public void checkingPickupAndDropOffLocations() {
        SoftAssert softAssert = new SoftAssert();
        CarsSearchResultsScreen carsSearchResultsScreen = new CarsSearchResultsScreen();
        softAssert.assertEquals(pickUpLocation, carsSearchResultsScreen.getInfoAboutPickUpLocationFromSummary(),
                "Input set up location is not equals summary set up location.");
        softAssert.assertEquals(dropOffLocation, carsSearchResultsScreen.getInfoAboutDropOffLocationFromSummary(),
                "Input drop off location is not equals summary drop off location.");
        softAssert.assertAll();
    }
}
