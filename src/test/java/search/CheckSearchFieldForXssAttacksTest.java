package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;

public class CheckSearchFieldForXssAttacksTest extends BaseSearchTest {

    @BeforeClass(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String nonExistProduct = "alert('I hacked this!')";
        searchPage = new Header()
                .typeTextToSearchInput(nonExistProduct)
                .clickSearchButton();
    }

    @Test(description = "checks the search field for XSS attacks")
    public void checkTheSearchFieldByXssAttack() {
        String expectedResult = "There is no product that matches the search criteria.";
        Assert.assertEquals(searchPage.getNoSearchResultsMessage(), expectedResult,
                expectedResult + "is not displayed.");
    }
}
