import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.cars.carService.CarSearchService;
import utils.Constants;


public class CheckAgeAlertTest extends BaseTest {
    CarsSearchResultsScreen carsSearchResultsScreen;
    String pickUpLocation = Constants.MOSCOW_SHEREMETYEVO_SVO;
    String driversAge = Constants.AGE_21;

    @BeforeClass(description = "click on car button, set up location, clear checkbox age, set driver's age and click search")
    public void navigateToCarSearchScreenAndFindCarUsingData() {
        carsSearchResultsScreen = new CarSearchService().searchCarUsingAgeAndPickUpLocation(pickUpLocation, driversAge);
    }

    @Test(description = "check is age alert message appeared on search result page")
    public void checkingAppearanceAgeAlert() {
        Assert.assertTrue(carsSearchResultsScreen.isAgeAlertVisible(), "Age Alert is not visible");
    }
}
