package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.Header;
import ru.awesome.shop.ta.product.pages.SearchPage;

public class CheckSearchResultByPressingTheEnterKeyTest extends BaseSearchTest {

    @BeforeClass(description = "clear search bar, enter text by 'Enter' key")
    public void preparingForTheTest() {
        String enter = "\n";
        String iPod = "iPod";
        new Header()
                .typeTextToSearchInput(iPod + enter);
    }

    @Test(description = "***SearchResultByPressingTheEnter***\n" +
            "EPMFARMATS-13138: check the search result by pressing the enter key\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13138")
    public void checkTheSearchResultByPressingTheEnterKey() {
        String expectedResult = "iPod Classic";
        Assert.assertTrue(new SearchPage().isSearchResultNameVisible(expectedResult),
                expectedResult + "wasn't found in search result");
    }
}
