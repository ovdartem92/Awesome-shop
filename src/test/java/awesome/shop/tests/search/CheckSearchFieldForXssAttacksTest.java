package awesome.shop.tests.search;

import awesome.shop.tests.BaseSearchTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchFieldForXssAttacksTest extends BaseSearchTest {

    @BeforeMethod(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String nonExistProduct = "alert('I hacked this!')";
        searchPage = new SearchResultPage()
                .typeSearchQuery(nonExistProduct)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultForXssAttacks***\n" +
            "EPMFARMATS-13136: check the search field for XSS attacks\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13136")
    public void checkTheSearchFieldByXssAttack() {
        String expectedResult = "There is no product that matches the search criteria.";
        Assert.assertEquals(searchPage.getNegativeSearchResultsMessage(), expectedResult,
                expectedResult + " is not displayed.");
    }
}
