import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerHotelResultPage;
import service.UserBuilder;

public class CheckingSortOfRatingInHotelBookingTest extends CommonConditions {

    @Test
    public void checkingMaximumValues() {
        String destination = "Moscow";
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerHotelResultPage resultPage  = new SkyScannerHomePage()
                .openPage()
                .switchToEnglish()
                .logIn(user)
                .clickToHostelsTab()
                    .addDestination(destination)
                    .clickToSearchHotelsButton()
                        .clickToGuestRattingSortButton();

        softAssert.assertEquals(resultPage.isHotelsSortedByRating(), true);
    }
}
