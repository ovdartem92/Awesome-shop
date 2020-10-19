import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.hotel.SkyScannerSearchHotelPage;
import service.UserBuilder;

public class CheckingMaximumValuesForHotelBookingTest extends CommonConditions {
    private final static int MAX_ROOMS_QUANTITY = 5;
    private final static int MAX_ADULT_PEOPLE_QUANTITY = 10;
    private final static int MAX_CHILDREN_QUANTITY = 5;

    @Test
    public void checkingMaximumValues() {
        String destination = "Turin";
        int clickQuantity = 12;
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerSearchHotelPage searchHotelPage = new SkyScannerHomePage()
                .logIn(user)
                .clickToHostelsTab();

        searchHotelPage.addDestination(destination)
                .increaseRoom(clickQuantity)
                .increaseAdult(clickQuantity)
                .increaseChild(clickQuantity);

        softAssert.assertEquals(searchHotelPage.getQuantityRooms(), MAX_ROOMS_QUANTITY);
        softAssert.assertEquals(searchHotelPage.getQuantityAdultPeople(), MAX_ADULT_PEOPLE_QUANTITY);
        softAssert.assertEquals(searchHotelPage.getQuantityChildren(), MAX_CHILDREN_QUANTITY);
    }
}
