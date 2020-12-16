package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;

public class CheckSearchResultByPartOfWordsInReverseOrderTest extends BaseSearchTest {

    @BeforeClass(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String reverse_part_iPod_classic = "Class Pod";
        searchPage = new Header()
                .typeTextToSearchInput(reverse_part_iPod_classic)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultByPartOfWords***\n" +
            "EPMFARMATS-13132: check the search result by part of words in reverse order\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13132")
    public void checkTheSearchResultByPartProductNameInReverse() {
        String expectedResult = "iPod Classic";
        Assert.assertTrue(searchPage.isSearchResultNameVisible(expectedResult),
                expectedResult + "wasn't found in search result");
    }
}
