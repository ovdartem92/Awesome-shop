import constants.Constants;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerHotelResultPage;
import service.UserBuilder;

public class CheckSortOfRatingInHotelBookingTest extends BaseTest {

    @Test
    public void checkingMaximumValues() {
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerHotelResultPage resultPage = new SkyScannerHomePage()
                .getHeader()
                .switchToEnglish()
                .logIn(user)
                .getHeader()
                .clickToHostelsTab()
                .addDestination(Constants.MOSCOW)
                .clickToSearchHotelsButton()
                .clickToGuestRattingSortButton();

//        Assert.assertEquals(resultPage.isHotelsSortedByRating(), true);
    }
}
