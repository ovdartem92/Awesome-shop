import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import utils.Constants;

public class CheckPickUpAndDropOffLocationsSummaryTest extends BaseTest {
    @Test
    public void checkingPickupAndDropOffLocations() {

        HeaderScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        CarsSearchResultsScreen carsSearchResultsScreen = new HeaderScreen()
                .clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(Constants.MOSCOW_SHEREMETYEVO_SVO)
                .setUpDropOffLocation(Constants.MOSCOW_VNUKOVO_VKO)
                .clickSearchButton();

        Assert.assertEquals(Constants.MOSCOW_SHEREMETYEVO_SVO, carsSearchResultsScreen.getInfoAboutPickUpLocationFromSummary(),
                "Input set up location are not equals summary set up location.");
        Assert.assertEquals(Constants.MOSCOW_VNUKOVO_VKO, carsSearchResultsScreen.getInfoAboutDropOffLocationFromSummary(),
                "Input drop off location are not equals summary drop off location.");

    }
}
