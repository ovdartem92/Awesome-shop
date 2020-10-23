import constants.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.car.SkyScannerCarSearchResultPage;
import page.net.skyscanner.SkyScannerHomePage;
import service.TestDataReader;
import service.UserBuilder;

public class CheckPickupAndDropOffLocationsForCarHireSearchResultPageTest extends BaseTest {

    @Test
    public void checkingPickupAndDropOffLocations() {
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerCarSearchResultPage skyScannerCarSearchResultPage = new SkyScannerHomePage()
                .switchToEnglish()
                .logIn(user)
                .clickToCarHireTab().setUpPickUpLocation(Location.MOSCOW_SHEREMETYEVO_SVO)
                .choiceReturnCarToADifferentLocation()
                .setUpDropOffLocation(TestDataReader.getTestData(Location.MOSCOW_VNUKOVO_VKO))
                .clickSearchButton();

        Assert.assertEquals(Location.MOSCOW_VNUKOVO_VKO, skyScannerCarSearchResultPage.getInfoAboutDropOffLocationFromSummary());
        Assert.assertEquals(Location.MOSCOW_SHEREMETYEVO_SVO, skyScannerCarSearchResultPage.getInfoAboutPickUpLocationFromSummary());
    }
}
