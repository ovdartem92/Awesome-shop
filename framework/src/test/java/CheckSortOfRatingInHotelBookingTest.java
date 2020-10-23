import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerHotelResultPage;
import service.UserBuilder;

public class CheckSortOfRatingInHotelBookingTest extends BaseTest {

    @Test
    public void checkingMaximumValues() {
        String destination = "Moscow";
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerHotelResultPage resultPage = new SkyScannerHomePage()
                .switchToEnglish()
                .logIn(user)
                .clickToHostelsTab()
                .addDestination(destination)
                .clickToSearchHotelsButton()
                .clickToGuestRattingSortButton();

        Assert.assertEquals(resultPage.isHotelsSortedByRating(), true);
    }
}
