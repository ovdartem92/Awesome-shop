import constants.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.car.VipCarsChooseYourCarPage;
import page.net.skyscanner.car.VipCarsReserveYourCarPage;

public class CheckTotalCostsBetweenVipCarsPagesTest extends BaseTest {

    @Test
    public void compareCostBetweenVipCarsChoosePageAndVipCarsReservePage() {
        int numberOfListsElement = 1;

        VipCarsChooseYourCarPage chooseYourCarPage = new SkyScannerHomePage()
                .clickToCarHireTab()
                .setUpPickUpLocation(Location.MOSCOW_SHEREMETYEVO_SVO)
                .clickSearchButton()
                .clickOnResultOfSearching(numberOfListsElement)
                .clickOnSelectButton();

        VipCarsReserveYourCarPage reserveYourCarPage = new SkyScannerHomePage()
                .clickToCarHireTab()
                .setUpPickUpLocation(Location.MOSCOW_SHEREMETYEVO_SVO)
                .clickSearchButton()
                .clickOnResultOfSearching(numberOfListsElement)
                .clickOnSelectButton()
                .clickOnSelectButton(numberOfListsElement);

        Assert.assertEquals(reserveYourCarPage.getTotalRentalPrice(), chooseYourCarPage.getCarPriseFromElementOfList(numberOfListsElement));
    }
}
