import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AbstractScreen;
import pages.net.skyscanner.cars.CarsSearchScreen;

import utils.Constants;

public class CheckCarHireMenuButtonTest extends BaseTest {
    CarsSearchScreen carsSearchScreen;

    @BeforeMethod(description = "Click on car button")
    public void navigateToCarSearchPage() {
        carsSearchScreen = AbstractScreen.header.clickCarButton();
    }

    @Test(description = "check that car hire menu button leads to the car search page")
    public void checkCarHireMenuButton() {
        Assert.assertEquals(carsSearchScreen.getTextFromCarHeadline(), Constants.TEXT_ON_CAR_SEARCH_PAGE,
                "car hire menu button doesn't lead to the car search page");
    }
}
