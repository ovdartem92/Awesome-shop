import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.flights.FlightsSearchPage;
import utils.Constants;

public class CheckHotelsMenuButtonTest extends BaseTest {

    @Test(description = "check that hotels menu button leads to the hotels search page")
    public void checkHotelsMenuButton() {
        FlightsSearchPage.changeLanguage(Constants.ENGLISH_LANGUAGE);
        Assert.assertTrue(FlightsSearchPage.header.clickHotelButton().getTextFromHotelsSearchButton().contains("Search hotels"),
                "hotels menu button doesn't lead to the hotels search page");
    }
}
