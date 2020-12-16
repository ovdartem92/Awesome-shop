package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;

public class CheckSearchResultForTheFullProductNameInUppercaseTest extends BaseSearchTest {

    @BeforeClass(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String iPod = "iPod";
        searchPage = new Header()
                .typeTextToSearchInput(iPod.toUpperCase())
                .clickSearchButton();
    }

    @Test(description = "***SearchResultForFullNameInUppercase***\n" +
            "EPMFARMATS-13133: check the search result for the full product name in uppercase\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13133")
    public void checkTheSearchResultByFullNameProductInUpperCase() {
        String expectedResult = "iPod Classic";
        Assert.assertTrue(searchPage.isSearchResultNameVisible(expectedResult),
                expectedResult + "wasn't found in search result");
    }
}
