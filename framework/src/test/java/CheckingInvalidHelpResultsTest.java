
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.help.SkyScannerHelpSearchResultsPage;
import static util.RandomString.getRandomString;

public class CheckingInvalidHelpResultsTest extends CommonConditions {

    @Test
    public void checkInvalidResult (){
        String searchData = getRandomString();
        SkyScannerHelpSearchResultsPage resultsPage = new SkyScannerHomePage().openPage()
                .clickToHelpLink()
                .sendTextToSearchArea(searchData)
                .clickOnSearchButton();

        softAssert.assertEquals(resultsPage.isSearchResultInvalid(), true);
    }
}
