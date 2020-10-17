import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class CheckingMaximumValuesForHotelBookingTest extends CommonConditions {
    private final static int MAX_ROOMS_QUANTITY = 5;
    private final static int MAX_ADULT_PEOPLE_QUANTITY = 10;
    private final static int MAX_CHILDREN_QUANTITY = 5;

    @Test
    public void test() {
        String destination = "Turin";
        int clickQuantity  = 15;
        user = UserBuilder.getUserWithValidPassword();

        SkyScannerHomePage homePage = new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user)
                .clickToHostelsTab()
                .addDestination(destination)
                .increaseRoom(clickQuantity)
                .increaseAdult(clickQuantity)
                .increaseChild(clickQuantity);

        softAssert.assertEquals(homePage.getQuantityRooms(), MAX_ROOMS_QUANTITY);
        softAssert.assertEquals(homePage.getQuantityAdultPeople(), MAX_ADULT_PEOPLE_QUANTITY);
        softAssert.assertEquals(homePage.getQuantityChildren(), MAX_CHILDREN_QUANTITY);
    }
}
