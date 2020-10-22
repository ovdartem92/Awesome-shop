import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.car.VipCarsChooseYourCarPage;
import page.net.skyscanner.car.VipCarsReserveYourCarPage;

public class CheckingTotalCostsBetweenVipCarsPages extends BaseTest {

    @Test
    public void compareCostBetweenVipCarsChoosePageAndVipCarsReservePage (){
        String pickUpLocation = "Moscow Sheremetyevo (SVO)";
        int numberOfListsElement = 1;

        VipCarsChooseYourCarPage chooseYourCarPage = new SkyScannerHomePage()
                .openPage()
                .clickToCarHireTab()
                .setUpPickUpLocation(pickUpLocation)
                .clickSearchButton()
                .clickOnResultOfSearching(numberOfListsElement)
                .clickOnSelectButton();

        VipCarsReserveYourCarPage reserveYourCarPage = new SkyScannerHomePage()
                .openPage()
                .clickToCarHireTab()
                .setUpPickUpLocation(pickUpLocation)
                .clickSearchButton()
                .clickOnResultOfSearching(numberOfListsElement)
                .clickOnSelectButton()
                .clickOnSelectButton(numberOfListsElement);

        softAssert.assertEquals(reserveYourCarPage.getTotalRentalPrice(), chooseYourCarPage.getCarPriseFromElementOfList(numberOfListsElement) );

    }
}
