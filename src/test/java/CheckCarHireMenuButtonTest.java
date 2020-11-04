import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.CultureService;
import utils.Constants;

public class CheckCarHireMenuButtonTest extends BaseTest {

    @Test(description = "check that car hire menu button leads to the car search page")
    public void checkCarHireMenuButton() {
        new HeaderScreen().clickRegionalSettingsButton();
        new CultureService().changeLanguage(Constants.ENGLISH_LANGUAGE);
        Assert.assertEquals(new HeaderScreen().clickCarButton().getTextFromCarHeader(), "Find your ride",
                "car hire menu button doesn't lead to the car search page");
    }
}
