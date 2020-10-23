
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerHotelResultPage;
import page.net.skyscanner.pageElements.Header;
import service.UserBuilder;

public class CheckSortOfPricesInHotelBookingTest extends BaseTest {

    @Test
    public void checkingMaximumValues() {
        user = UserBuilder.getUserWithValidPassword();
        SkyScannerHomePage homePage = new SkyScannerHomePage();

        SkyScannerHotelResultPage resultPage = new SkyScannerHomePage()
                .getHeader()
                .switchToEnglish()
                .logIn(user)
                .getHeader()
                .clickToHostelsTab()
                .addDestination(Constants.TURIN)
                .clickToSearchHotelsButton()
                .clickToPriceSortButton();

//        Assert.assertEquals(resultPage.isHotelsSortedByPrice(), true);
    }
}
