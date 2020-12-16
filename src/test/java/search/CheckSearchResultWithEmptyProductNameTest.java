package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;

public class CheckSearchResultWithEmptyProductNameTest extends BaseSearchTest {

    @BeforeClass(description = "clear search bar, click to the search button")
    public void preparingForTheTest() {
        searchPage = new Header()
                .typeTextToSearchInput("")
                .clickSearchButton();
    }

    @Test(description = "***SearchResultWithEmptyProductName***\n" +
            "EPMFARMATS-13123: check the search result for an empty product name.\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13123")
    public void checkTheSearchResultForAnEmptyProductName() {
        String expectedResult = "There is no product that matches the search criteria.";
        Assert.assertEquals(searchPage.getNoSearchResultsMessage(), expectedResult,
                expectedResult + "is not displayed.");
    }
}
