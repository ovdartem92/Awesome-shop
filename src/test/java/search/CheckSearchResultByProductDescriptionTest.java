package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;

public class CheckSearchResultByProductDescriptionTest extends BaseSearchTest {
    private final String iPod = "iPod Classic";

    @BeforeClass(description = "clear search bar, enter text, " +
            "click to the search button, set description, click search button")
    public void preparingForTheTest() {
        searchPage = new Header()
                .typeTextToSearchInput(iPod)
                .clickSearchButton()
                .setDescriptionCheckbox(true)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultByProductDescription***\n" +
            "EPMFARMATS-13134: check the search result by product description\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13134")
    public void checkTheSearchResultByProductDescription() {
        Assert.assertTrue(searchPage.isSearchResultNameVisible(iPod),
                iPod + "wasn't found in search result");
    }
}
