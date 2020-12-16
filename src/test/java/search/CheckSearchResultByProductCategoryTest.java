package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;

public class CheckSearchResultByProductCategoryTest extends BaseSearchTest {
    private final String iMac = "iMac";

    @BeforeClass(description = "clear search bar, enter text, " +
            "click to the search button, select category, click to the search button")
    public void preparingForTheTest() {
        int iMacIndex = 3;
        searchPage = new Header()
                .typeTextToSearchInput(iMac)
                .clickSearchButton()
                .selectCategory(iMacIndex)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultByProductCategory***\n" +
            "EPMFARMATS-13135: check the search result by product category\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13135")
    public void checkTheSearchResultByProductCategory() {
        Assert.assertTrue(searchPage.isSearchResultNameVisible(iMac),
                iMac + "wasn't found in search result");
    }
}
