import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.flights.FlightsSearchScreen;
import utils.Constants;

public class CheckCarHireMenuButtonTest extends BaseTest {
    private final String TEXT_ON_CAR_SEARCH_PAGE = "Find your ride";

    @Test(description = "check that car hire menu button leads to the car search page")
    public void checkCarHireMenuButton() {
        FlightsSearchScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        Assert.assertEquals(FlightsSearchScreen.header.clickCarButton().getTextFromCarHeadline(), TEXT_ON_CAR_SEARCH_PAGE,
                "car hire menu button doesn't lead to the car search page");
    }
}
