
import constants.Constants;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.resultPage.SkyScannerHotelResultPage;
import service.UserBuilder;

public class CheckSortOfPricesInHotelBookingTest extends BaseTest {

    @Test
    public void checkingMaximumValues() {
        user = UserBuilder.getUserWithValidPassword();
        SkyScannerHomePage homePage = new SkyScannerHomePage();

        SkyScannerHotelResultPage resultPage = new SkyScannerHomePage()
                .getHeader()
                .changeLanguage(Constants.ENGLISH_LANGUAGE)
                .logIn(user)
                .clickToHostelsTab()
                .addDestination(Constants.TURIN)
                .clickToSearchHotelsButton()
                .clickToPriceSortButton();

//        Assert.assertEquals(resultPage.isHotelsSortedByPrice(), true);
    }
}
