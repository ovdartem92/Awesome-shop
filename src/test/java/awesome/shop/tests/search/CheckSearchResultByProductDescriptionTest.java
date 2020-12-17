package awesome.shop.tests.search;

import awesome.shop.tests.BaseSearchTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchResultByProductDescriptionTest extends BaseSearchTest {
    private final String iPod = "iPod Classic";

    @BeforeMethod(description = "clear search bar, enter text, " +
            "click to the search button, set description, click search button")
    public void preparingForTheTest() {
        searchPage = new SearchResultPage()
                .typeSearchQuery(iPod)
                .clickSearchButton()
                .setDescriptionCheckbox(true)
                .clickSearchButtonAfterSearch();
    }

    @Test(description = "***SearchResultByProductDescription***\n" +
            "EPMFARMATS-13134: check the search result by product description\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13134")
    public void checkTheSearchResultByProductDescription() {
        int expectedResult = 2;
        Assert.assertTrue(searchPage.isSearchResultNameContainsOnSearchList(iPod),
                iPod + " wasn't found in search result");
        Assert.assertTrue(searchPage.getTotalNumberOfSearchResult() < expectedResult,
                " more than one product");
    }
}
