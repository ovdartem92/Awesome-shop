import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerHotelResultPage;
import service.UserBuilder;

public class CheckingSortOfPricesInHotelBookingTest extends CommonConditions {

    @Test
    public void checkingMaximumValues() {
        String destination = "Turin";
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerHotelResultPage resultPage  = new SkyScannerHomePage()
                .openPage()
                .switchToEnglish()
                .logIn(user)
                .clickToHostelsTab()
                    .addDestination(destination)
                    .clickToSearchHotelsButton()
                        .clickToPriceSortButton();

        softAssert.assertEquals(resultPage.isHotelsSortedByPrice(), true);
    }
}
