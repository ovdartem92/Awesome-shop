package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;

public class CheckSearchResultByFullProductNameInReverseOrderTest extends BaseSearchTest {

    @BeforeClass(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String reversedIPodClassic = "Classic iPod";
        searchPage = new Header()
                .typeTextToSearchInput(reversedIPodClassic)
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
