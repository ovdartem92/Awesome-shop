package awesome.shop.tests.search;

import awesome.shop.tests.BaseSearchTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class CheckSearchResultByPressingTheEnterKeyTest extends BaseSearchTest {

    @BeforeMethod(description = "clear search bar, enter text by 'Enter' key")
    public void preparingForTheTest() {
        String enter = "\n";
        String iPod = "i";
        new SearchResultPage()
                .typeSearchQuery(iPod + enter);
        for (int i = 0; i < new SearchResultPage().getAllSearchResults().size(); i++) {
            System.out.println(new SearchResultPage().getAllSearchResults().get(i).getPrice());
        }
    }

    @Test(description = "***SearchResultByPressingTheEnter***\n" +
            "EPMFARMATS-13138: check the search result by pressing the enter key\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13138")
    public void checkTheSearchResultByPressingTheEnterKey() {
        String expectedResult = "iPod Classic";
        Assert.assertTrue(new SearchResultPage().isSearchResultNameContainsOnSearchList(expectedResult),
                expectedResult + " wasn't found in search result");
    }
}
