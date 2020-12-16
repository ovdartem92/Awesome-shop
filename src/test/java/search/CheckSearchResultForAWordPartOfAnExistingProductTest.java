package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;

public class CheckSearchResultForAWordPartOfAnExistingProductTest extends BaseSearchTest {

    @BeforeClass(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String partOfName = "iPo";
        searchPage = new Header()
                .typeTextToSearchInput(partOfName)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultForAWordPartOfAnExistingProduct***\n" +
            "EPMFARMATS-13130: check the search result for a word part of an existing product\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13130")
    public void checkTheSearchResultForAWordPart() {
        String expectedResult = "iPod Classic";
        Assert.assertTrue(searchPage.isSearchResultNameVisible(expectedResult),
                expectedResult + "wasn't found in search result");
    }
}
