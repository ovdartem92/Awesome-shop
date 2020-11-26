import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import service.CarSearchService;
import utils.Constants;


public class CheckAgeAlertTest extends BaseTest {

    @BeforeClass(description = "click on car button, set up location, clear checkbox age, set driver's age and click search")
    public void navigateToCarSearchScreenAndFindCarUsingData() {
        new CarSearchService().searchCarUsingAgeAndPickUpLocation(Constants.MOSCOW_SHEREMETYEVO_SVO, Constants.AGE_21);
    }

    @Test(description = "check is age alert message appeared on search result page")
    public void checkingAppearanceAgeAlert() {
        Assert.assertTrue(new CarsSearchResultsScreen().isAgeAlertVisible(), "Age Alert is not visible");
    }
}
