import constants.Constants;
import driver.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.car.VipCarsChooseYourCarPage;
import page.net.skyscanner.car.VipCarsReserveYourCarPage;

public class CheckTotalCostsBetweenVipCarsPagesTest extends BaseTest {

    @Test
    public void compareCostBetweenVipCarsChoosePageAndVipCarsReservePage() {
        int numberOfListsElement = 1;

        String carPriseFromElementOfList = new SkyScannerHomePage()
                .getHeader()
                .clickToCarHireTab()
                .setUpPickUpLocation(Constants.MOSCOW_SHEREMETYEVO_SVO)
                .clickSearchButton()
                .clickOnResultOfSearching(numberOfListsElement)
                .clickOnSelectButton().getCarPriseFromElementOfList(numberOfListsElement);

        Browser.createNewTab();
        Browser.switchTabByIndex(4);

        String totalRentalPrice = new SkyScannerHomePage()
                .getHeader()
                .clickToCarHireTab()
                .setUpPickUpLocation(Constants.MOSCOW_SHEREMETYEVO_SVO)
                .clickSearchButton()
                .clickOnResultOfSearching(numberOfListsElement)
                .clickOnSelectButton()
                .clickOnSelectButton(numberOfListsElement).getTotalRentalPrice();

        Assert.assertEquals(carPriseFromElementOfList, totalRentalPrice);
    }
}
