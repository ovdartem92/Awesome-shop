import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.searchPage.SkyScannerHotelSearchPage;
import service.UserBuilder;

public class CheckMaximumValuesForHotelBookingTest extends BaseTest {
    private final static int MAX_ROOMS_QUANTITY = 5;
    private final static int MAX_ADULT_PEOPLE_QUANTITY = 10;
    private final static int MAX_CHILDREN_QUANTITY = 5;

    @Test
    public void checkingMaximumValues() {
        int clickQuantity = 12;
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerHotelSearchPage searchHotelPage = new SkyScannerHomePage()
                .getHeader()
                .changeLanguage(Constants.ENGLISH_LANGUAGE)
                .logIn(user)
                .clickToHostelsTab()
                .addDestination(Constants.TURIN)
                .increaseRoom(clickQuantity)
                .increaseAdult(clickQuantity)
                .increaseChild(clickQuantity);

        Assert.assertEquals(searchHotelPage.getQuantityRooms(), MAX_ROOMS_QUANTITY);
        Assert.assertEquals(searchHotelPage.getQuantityAdultPeople(), MAX_ADULT_PEOPLE_QUANTITY);
        Assert.assertEquals(searchHotelPage.getQuantityChildren(), MAX_CHILDREN_QUANTITY);
    }
}
