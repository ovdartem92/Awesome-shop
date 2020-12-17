package search;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchResultByProductCategoryTest extends BaseSearchTest {
    private final String iMac = "iMac";

    @BeforeMethod(description = "clear search bar, enter text, " +
            "click to the search button, select category, click to the search button")
    public void preparingForTheTest() {
        int iMacIndex = 3;
        searchPage = new SearchResultPage()
                .typeSearchQuery(iMac)
                .clickSearchButton()
                .selectCategory(iMacIndex)
                .clickSearchButtonAfterSearch();
    }

    @Test(description = "***SearchResultByProductCategory***\n" +
            "EPMFARMATS-13135: check the search result by product category\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13135")
    public void checkTheSearchResultByProductCategory() {
        Assert.assertTrue(searchPage.isSearchResultNameVisible(iMac),
                iMac + "wasn't found in search result");
    }
}
