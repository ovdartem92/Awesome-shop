import constants.Constants;
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
                .getHeader()
                .switchToEnglish()
                .logIn(user)
                .getHeader()
                .clickToCarHireTab().setUpPickUpLocation(Constants.MOSCOW_SHEREMETYEVO_SVO)
                .choiceReturnCarToADifferentLocation()
                .setUpDropOffLocation(TestDataReader.getTestData(Constants.MOSCOW_VNUKOVO_VKO))
                .clickSearchButton();

        Assert.assertEquals(Constants.MOSCOW_VNUKOVO_VKO, skyScannerCarSearchResultPage.getInfoAboutDropOffLocationFromSummary());
        Assert.assertEquals(Constants.MOSCOW_SHEREMETYEVO_SVO, skyScannerCarSearchResultPage.getInfoAboutPickUpLocationFromSummary());
    }
}
