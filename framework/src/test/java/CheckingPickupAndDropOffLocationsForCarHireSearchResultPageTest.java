import org.testng.annotations.Test;
import page.net.skyscanner.car.SkyScannerCarSearchResultPage;
import page.net.skyscanner.SkyScannerHomePage;
import service.TestDataReader;
import service.UserBuilder;

public class CheckingPickupAndDropOffLocationsForCarHireSearchResultPageTest extends BaseTest {

    @Test
    public void checkingPickupAndDropOffLocations() {
        String pickUpLocation = "Moscow Sheremetyevo (SVO)";
        String dropOffLocation = "Moscow Vnukovo (VKO)";
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerCarSearchResultPage skyScannerCarSearchResultPage = new SkyScannerHomePage()
                .openPage()
                .switchToEnglish()
                .logIn(user)
                .clickToCarHireTab().setUpPickUpLocation(pickUpLocation)
                .choiceReturnCarToADifferentLocation()
                .setUpDropOffLocation(TestDataReader.getTestData(dropOffLocation))
                .clickSearchButton();

        softAssert.assertEquals(dropOffLocation, skyScannerCarSearchResultPage.getInfoAboutDropOffLocationFromSummary());
        softAssert.assertEquals(pickUpLocation, skyScannerCarSearchResultPage.getInfoAboutPickUpLocationFromSummary());
    }
}
