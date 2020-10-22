import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.car.SkyScannerCarSearchResultPage;
import page.net.skyscanner.SkyScannerHomePage;
import service.TestDataReader;
import service.UserBuilder;

public class CheckPickupAndDropOffLocationsForCarHireSearchResultPageTest extends BaseTest {

    @Test
    public void checkingPickupAndDropOffLocations() {
        String pickUpLocation = "Moscow Sheremetyevo (SVO)";
        String dropOffLocation = "Moscow Vnukovo (VKO)";
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerCarSearchResultPage skyScannerCarSearchResultPage = new SkyScannerHomePage()
                .switchToEnglish()
                .logIn(user)
                .clickToCarHireTab().setUpPickUpLocation(pickUpLocation)
                .choiceReturnCarToADifferentLocation()
                .setUpDropOffLocation(TestDataReader.getTestData(dropOffLocation))
                .clickSearchButton();

        Assert.assertEquals(dropOffLocation, skyScannerCarSearchResultPage.getInfoAboutDropOffLocationFromSummary());
        Assert.assertEquals(pickUpLocation, skyScannerCarSearchResultPage.getInfoAboutPickUpLocationFromSummary());
    }
}
