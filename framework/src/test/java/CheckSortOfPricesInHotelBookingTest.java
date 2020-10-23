import constants.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerHotelResultPage;
import service.UserBuilder;

public class CheckSortOfPricesInHotelBookingTest extends BaseTest {

    @Test
    public void checkingMaximumValues() {
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerHotelResultPage resultPage = new SkyScannerHomePage()
                .switchToEnglish()
                //.logIn(user)
                .clickToHostelsTab()
                .addDestination(Location.TURIN)
                .clickToSearchHotelsButton()
                .clickToPriceSortButton();

        Assert.assertEquals(resultPage.isHotelsSortedByPrice(), true);
    }
}
