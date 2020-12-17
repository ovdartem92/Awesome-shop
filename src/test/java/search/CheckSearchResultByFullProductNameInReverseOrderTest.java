package search;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchResultByFullProductNameInReverseOrderTest extends BaseSearchTest {

    @BeforeMethod(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String reversedIPodClassic = "Classic iPod";
        searchPage = new SearchResultPage()
                .typeSearchQuery(reversedIPodClassic)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultReversed***\n" +
            "EPMFARMATS-13131: check the search result by full product name in reverse order\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13131")
    public void checkTheSearchResultByFullProductNameInReverse() {
        String expectedResult = "iPod Classic";
        Assert.assertTrue(searchPage.isSearchResultNameVisible(expectedResult),
                expectedResult + "wasn't found in search result");
    }
}
