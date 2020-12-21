package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class SearchTest extends BaseConfigurationTest {
    SearchResultPage searchResultPage = new SearchResultPage();

    @DataProvider(name = "negativeSearchData")
    public Object[][] negativeSearchData() {
        return new Object[][]{
                {"alert('I hacked this!')"},
                {"Mercedes GLE-Coupe"},
                {""},
                {" "},
        };
    }

    @DataProvider(name = "positiveSearchData")
    public Object[][] providePositiveTestData() {
        return new Object[][]{
                {"Classic iPod",},
                {"Class Pod"},
                {"iPod Classic"},
                {"iPo"},
                {"IPOD"},
        };
    }

    @BeforeMethod(description = "open search-page",
            groups = {"all", "negative", "positive"})
    public void preparingForTheTest() {
        searchResultPage.open();
    }

    @Test(description = "***NegativeSearchResultTests***\n" +
            "EPMFARMATS-13136: check the search field for XSS attacks\n" +
            "EPMFARMATS-13129: check the search result for a non-existent product\n" +
            "EPMFARMATS-13137: checks the search result when typing a space.\n" +
            "EPMFARMATS-13123: check the search result for an empty product name.\n",
            dataProvider = "negativeSearchData", groups = "negative")
    public void checkTheSearchFieldByNegativeSearchData(String searchData) {
        String expectedResult = "There is no product that matches the search criteria.";
        searchResultPage.typeSearchQuery(searchData);
        searchResultPage.clickSearchButton();
        Assert.assertEquals(searchResultPage.getIncorrectSearchCriteriaMessage(), expectedResult,
                expectedResult + " is not displayed.");
    }

    @Test(description = "***PositiveSearchResultTests***\n" +
            "EPMFARMATS-13133: check the search result for the full product name in uppercase\n" +
            "EPMFARMATS-13130: check the search result for a word part of an existing product\n" +
            "EPMFARMATS-13128: check the search result for an existing product by full name\n" +
            "EPMFARMATS-13132: check the search result by part of words in reverse order\n" +
            "EPMFARMATS-13131: check the search result by full product name in reverse order\n",
            dataProvider = "providePositiveTestData", groups = "positive")
    public void checkTheSearchFieldByPositiveSearchData(String searchData) {
        String expectedResult = "iPod Classic";
        searchResultPage.typeSearchQuery(searchData);
        searchResultPage.clickSearchButton();
        Assert.assertEquals(searchResultPage.getFirstSearchResultName(), expectedResult,
                expectedResult + " is not displayed.");
    }

    @Test(description = "***SearchResultByPressingTheEnter***\n" +
            "EPMFARMATS-13138: check the search result by pressing the enter key\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13138", groups = "positive")
    public void checkTheSearchResultByPressingTheEnterKey() {
        String expectedResult = "iPod Classic";
        String enter = "\n";
        String iPod = "iPod";
        searchResultPage.typeSearchQuery(iPod + enter);
        searchResultPage.getAllSearchResultsList().get(0).getPrice();
        Assert.assertEquals(searchResultPage.getFirstSearchResultName(), expectedResult,
                expectedResult + " wasn't found in search result");
    }

    @Test(description = "***SearchResultByProductCategory***\n" +
            "EPMFARMATS-13135: check the search result by product category\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13135", groups = "positive")
    public void checkTheSearchResultByProductCategory() {
        String iMac = "      Mac";
        String expectedResult = "iMac";
        searchResultPage
                .typeSearchQuery(iMac)
                .clickSearchButton()
                .selectCategory(iMac)
                .clickSearchButtonAfterSearch();
        Assert.assertEquals(searchResultPage.getFirstSearchResultName(), expectedResult,
                iMac + " wasn't found in search result");
    }

    @Test(description = "***SearchResultByProductDescription***\n" +
            "EPMFARMATS-13134: check the search result by product description\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13134", groups = "positive")
    public void checkTheSearchResultByProductDescription() {
        String iPod = "iPod Classic";
        searchResultPage
                .typeSearchQuery(iPod)
                .clickSearchButton()
                .setDescriptionCheckbox(true)
                .clickSearchButtonAfterSearch();
        Assert.assertEquals(searchResultPage.getFirstSearchResultName(), iPod,
                iPod + " wasn't found in search result");
    }
}
