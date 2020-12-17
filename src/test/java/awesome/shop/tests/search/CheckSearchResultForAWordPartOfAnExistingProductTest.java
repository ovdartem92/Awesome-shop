package awesome.shop.tests.search;

import awesome.shop.tests.BaseSearchTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchResultForAWordPartOfAnExistingProductTest extends BaseSearchTest {

    @BeforeMethod(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String partOfName = "iPo";
        searchPage = new SearchResultPage()
                .typeSearchQuery(partOfName)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultForAWordPartOfAnExistingProduct***\n" +
            "EPMFARMATS-13130: check the search result for a word part of an existing product\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13130")
    public void checkTheSearchResultForAWordPart() {
        String expectedResult = "iPod Classic";
        int expectedIndexOfProduct = 0;
        Assert.assertTrue(searchPage.isSearchResultNameContainsOnSearchList(expectedResult),
                expectedResult + " wasn't found in search result");
        Assert.assertEquals(searchPage.getNameSearchProductByIndex(expectedIndexOfProduct), expectedResult);
    }
}
