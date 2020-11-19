import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.cars.CarsSearchScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import utils.Constants;

public class CheckCarHireMenuButtonTest extends BaseTest {
    CarsSearchScreen carsSearchScreen;

    @BeforeClass(description = "Click on car button")
    public void navigateToCarSearchPage() {
        carsSearchScreen = HeaderScreen.header.clickCarButton();
    }

    @Test(description = "check that car hire menu button leads to the car search page")
    public void checkCarHireMenuButton() {
        Assert.assertEquals(carsSearchScreen.getTextFromCarHeadline(), Constants.TEXT_ON_CAR_SEARCH_PAGE,
                "car hire menu button doesn't lead to the car search page");
    }
}
