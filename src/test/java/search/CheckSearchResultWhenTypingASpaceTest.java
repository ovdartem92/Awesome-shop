package search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.product.pages.Header;
import ru.awesome.shop.ta.utils.TestDataReader;

public class CheckSearchResultWhenTypingASpaceTest extends BaseSearchTest {
    @BeforeClass(description = "clear search bar, enter text, click to the search button")
    public void preparingForTheTest() {
        String space = " ";
        new Header()
                .typeTextToSearchInput(space)
                .clickSearchButton();
    }

    @Test(description = "***SearchResultWhenTypingASpace***\n" +
            "EPMFARMATS-13137: checks the search result when typing a space.\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13137")
    public void checkTheSearchResultWithSpace() {
        Assert.assertEquals(Browser.getInstance().getWrappedDriver().getCurrentUrl(),
                TestDataReader.getStageData("home.url"), "The URLs are not the same");
    }
}
