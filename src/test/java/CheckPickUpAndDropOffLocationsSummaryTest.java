import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AbstractScreen;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import utils.Constants;

public class CheckPickUpAndDropOffLocationsSummaryTest extends BaseTest {
    CarsSearchResultsScreen carsSearchResultsScreen;
    String pickUpLocation = Constants.MOSCOW_SHEREMETYEVO_SVO;
    String dropOffLocation = Constants.MOSCOW_VNUKOVO_VKO;

    @BeforeClass(description = "Click on car button")
    public void navigateToCarSearchPage() {
        carsSearchResultsScreen = AbstractScreen.header.clickCarButton().searchCarUsingLocationsData(pickUpLocation, dropOffLocation);
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
