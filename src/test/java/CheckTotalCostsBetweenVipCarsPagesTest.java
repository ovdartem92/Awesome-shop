import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import utils.Constants;

public class CheckTotalCostsBetweenVipCarsPagesTest extends BaseTest {
    @Test
    public void checkingCostsBetweenVipCarsPages() {
        String pickUpLocation = Constants.MOSCOW_SHEREMETYEVO_SVO;
        HeaderScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
            new HeaderScreen()
                .clickCarButton()
                .setUpPickUpLocation(pickUpLocation)
                .clickSearchButton()
                .clickOnResultOfSearching(0)
                .clickOnSelectButton()
                //.waitForDownloadVipCars()
                .getCarPriseFromElementOfList(0);
                //.clickOnSelectButtonOnVipPage(0);
    }
}
