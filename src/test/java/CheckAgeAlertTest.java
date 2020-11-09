import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import utils.Constants;

public class CheckAgeAlertTest extends BaseTest {
    @Test
    public void checkingAppearanceAgeAlert() {
        String pickUpLocation = Constants.MOSCOW_SHEREMETYEVO_SVO;
        String age = Constants.AGE_21;
        HeaderScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        CarsSearchResultsScreen carsSearchResultsScreen = new HeaderScreen()
                .clickCarButton()
                .setAgeCheckbox()
                .setDriverAge(age)
                .setUpPickUpLocation(pickUpLocation)
                .clickSearchButton();
        Assert.assertTrue(carsSearchResultsScreen.isAgeAlertVisible(), "Age Alert is not visible");
    }
}
