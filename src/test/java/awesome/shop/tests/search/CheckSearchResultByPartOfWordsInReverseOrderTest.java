package awesome.shop.tests.search;

import awesome.shop.tests.BaseSearchTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchResultByPartOfWordsInReverseOrderTest extends BaseSearchTest {

    @BeforeMethod(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String reverse_part_iPod_classic = "Class Pod";
        searchPage = new SearchResultPage()
                .typeSearchQuery(reverse_part_iPod_classic)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultByPartOfWords***\n" +
            "EPMFARMATS-13132: check the search result by part of words in reverse order\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13132")
    public void checkTheSearchResultByPartProductNameInReverse() {
        String expectedResult = "iPod Classic";
        Assert.assertTrue(searchPage.isSearchResultNameContainsOnSearchList(expectedResult),
                expectedResult + " wasn't found in search result");
    }
}
