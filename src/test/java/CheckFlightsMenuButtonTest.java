import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.CultureService;
import utils.Constants;

public class CheckFlightsMenuButtonTest extends BaseTest {

    @Test(description = "check that flights menu button leads to the flights search page")
    public void checkFlightsMenuButton() {
        new HeaderScreen().clickRegionalSettingsButton();
        new CultureService().changeLanguage(Constants.ENGLISH_LANGUAGE);
        Assert.assertEquals(new HeaderScreen().clickFlightButton()
                        .getTextFromFlightsSearchButton(), "Search flights",
                "flights menu button doesn't lead to the flights search page");
    }
}
