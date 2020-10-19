import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerHotelResultPage;
import page.net.skyscanner.hotel.SkyScannerSearchHotelPage;
import service.UserBuilder;

public class CheckingSortOfPricesInHotelBookingTest extends CommonConditions {

    @Test
    public void checkingMaximumValues() {
        String destination = "Turin";
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerSearchHotelPage searchHotelPage =
                new SkyScannerHomePage()
                .openPage()
                .logIn(user)
                .clickToHostelsTab();

        SkyScannerHotelResultPage resultPage = searchHotelPage.addDestination(destination)
                                                              .clickToSearchHotelsButton()
                                                              .clickToPriceSortButton();

        softAssert.assertEquals(resultPage.isHotelsSortedByPrice(), true);
    }
}
