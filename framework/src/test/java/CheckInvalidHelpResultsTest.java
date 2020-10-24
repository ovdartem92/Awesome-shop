
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.help.SkyScannerHelpSearchResultsPage;
import static util.RandomString.getRandomString;

public class CheckInvalidHelpResultsTest extends BaseTest {

    @Test
    public void checkInvalidResult (){
        String searchData = getRandomString();
        SkyScannerHelpSearchResultsPage resultsPage = new SkyScannerHomePage()
                .clickToHelpLink()
                .sendTextToSearchArea(searchData)
                .clickOnSearchButton();

        Assert.assertTrue(resultsPage.isSearchResultInvalid());
    }
}