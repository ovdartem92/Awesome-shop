package awesome.shop.tests.search;

import awesome.shop.tests.BaseSearchTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchResultForANonExistentProductTest extends BaseSearchTest {

    @BeforeMethod(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String nonExistProduct = "Mercedes GLE-Coupe";
        searchPage = new SearchResultPage()
                .typeSearchQuery(nonExistProduct)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultForANonExistentProduct***\n" +
            "EPMFARMATS-13129: check the search result for a non-existent product\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13129")
    public void checkTheSearchResultForANonExistentProduct() {
        String expectedResult = "There is no product that matches the search criteria.";
        Assert.assertEquals(searchPage.getNegativeSearchResultsMessage(), expectedResult,
                expectedResult + " is not displayed.");
    }
}
