import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.CultureService;
import utils.Constants;

public class CheckHotelsMenuButtonTest extends BaseTest {
    @Test(description = "check that hotels menu button leads to the hotels search page")
    public void checkHotelsMenuButton() {
        new HeaderScreen().clickRegionalSettingsButton();
        new CultureService().changeLanguage(Constants.ENGLISH_LANGUAGE);
        Assert.assertTrue(new HeaderScreen().clickHotelButton()
                        .getTextFromHotelsSearchButton().contains("Search hotels"),
                "hotels menu button doesn't lead to the hotels search page");
    }
}
