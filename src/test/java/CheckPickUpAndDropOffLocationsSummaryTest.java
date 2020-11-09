import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import utils.Constants;

public class CheckPickUpAndDropOffLocationsSummaryTest extends BaseTest {
    @Test
    public void checkingPickupAndDropOffLocations() {
        String pickUpLocation = Constants.MOSCOW_SHEREMETYEVO_SVO;
        String dropOffLocation = Constants.MOSCOW_VNUKOVO_VKO;
        HeaderScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        CarsSearchResultsScreen carsSearchResultsScreen = new HeaderScreen()
                .clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLocation)
                .setUpDropOffLocation(dropOffLocation)
                .clickSearchButton();

        Assert.assertEquals(pickUpLocation, carsSearchResultsScreen.getInfoAboutPickUpLocationFromSummary(),
                "Input set up location is not equals summary set up location.");
        Assert.assertEquals(dropOffLocation, carsSearchResultsScreen.getInfoAboutDropOffLocationFromSummary(),
                "Input drop off location is not equals summary drop off location.");

    }
}
