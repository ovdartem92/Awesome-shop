package awesome.shop.tests.search;

import awesome.shop.tests.BaseSearchTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchResultForTheFullProductNameInUppercaseTest extends BaseSearchTest {

    @BeforeMethod(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String iPod = "iPod";
        searchPage = new SearchResultPage()
                .typeSearchQuery(iPod.toUpperCase())
                .clickSearchButton();
    }

    @Test(description = "***SearchResultForFullNameInUppercase***\n" +
            "EPMFARMATS-13133: check the search result for the full product name in uppercase\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13133")
    public void checkTheSearchResultByFullNameProductInUpperCase() {
        String expectedResult = "iPod Classic";
        Assert.assertTrue(searchPage.isSearchResultNameContainsOnSearchList(expectedResult),
                expectedResult + " wasn't found in search result");
    }
}
