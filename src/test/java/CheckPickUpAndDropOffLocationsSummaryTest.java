import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import utils.Constants;

public class CheckPickUpAndDropOffLocationsSummaryTest extends BaseTest {
    @Test(description = "check input values of locations are equals locations in search result page summary")
    public void checkingPickupAndDropOffLocations() {
        SoftAssert softAssert = new SoftAssert();
        String pickUpLocation = Constants.MOSCOW_SHEREMETYEVO_SVO;
        String dropOffLocation = Constants.MOSCOW_VNUKOVO_VKO;
        HeaderScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        CarsSearchResultsScreen carsSearchResultsScreen = new HeaderScreen()
                .clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLocation)
                .setUpDropOffLocation(dropOffLocation)
                .clickSearchButton();

        String pickUpLocationSummary = carsSearchResultsScreen.getInfoAboutPickUpLocationFromSummary();
        String dropOffLocationSummary = carsSearchResultsScreen.getInfoAboutDropOffLocationFromSummary();

        softAssert.assertEquals(pickUpLocation, pickUpLocationSummary,
                "Input set up location is not equals summary set up location.");
        softAssert.assertEquals(dropOffLocation, dropOffLocationSummary,
                "Input drop off location is not equals summary drop off location.");
        softAssert.assertAll();
    }
}
