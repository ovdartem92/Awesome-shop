package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class SearchTest extends BaseConfigurationTest {
    private final String expectedResultIPod = "iPod Classic";
    SearchResultPage searchResultPage = new SearchResultPage();

    @DataProvider(name = "negativeSearchData")
    public Object[][] provideNegativeTestData() {
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
                {expectedResultIPod},
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
            "EPMFARMATS-13123: check the search result for an empty product name.\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13136" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13129" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13137" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13123",
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
            "EPMFARMATS-13131: check the search result by full product name in reverse order\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13133" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13130" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13128" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13132" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13131",
            dataProvider = "positiveSearchData", groups = "positive")
    public void checkTheSearchFieldByPositiveSearchData(String searchData) {
        searchResultPage.typeSearchQuery(searchData);
        searchResultPage.clickSearchButton();
        Assert.assertEquals(searchResultPage.getFirstSearchResultFragment().getName(), expectedResultIPod,
                expectedResultIPod + " is not displayed.");
    }

    @Test(description = "***SearchResultByPressingTheEnter***\n" +
            "EPMFARMATS-13138: check the search result by pressing the enter key\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13138", groups = "positive")
    public void checkTheSearchResultByPressingTheEnterKey() {
        String enter = "\n";
        String iPod = "iPod";
        searchResultPage.typeSearchQuery(iPod + enter);
        Assert.assertEquals(searchResultPage.getFirstSearchResultFragment().getName(), expectedResultIPod,
                expectedResultIPod + " wasn't found in search result");
    }

    @Test(description = "***SearchResultByProductCategory***\n" +
            "EPMFARMATS-13135: check the search result by product category\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13135", groups = "positive")
    public void checkTheSearchResultByProductCategory() {
        String iMacCategory = "      Mac";
        String expectedResult = "iMac";
        searchResultPage
                .typeSearchQuery(iMacCategory)
                .clickSearchButton()
                .selectCategory(iMacCategory)
                .clickSearchButtonAfterSearch();
        Assert.assertEquals(searchResultPage.getFirstSearchResultFragment().getName(), expectedResult,
                expectedResult + " wasn't found in search result");
    }

    @Test(description = "***SearchResultByProductDescription***\n" +
            "EPMFARMATS-13134: check the search result by product description\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13134", groups = "positive")
    public void checkTheSearchResultByProductDescription() {
        searchResultPage
                .typeSearchQuery(expectedResultIPod)
                .clickSearchButton()
                .setDescriptionCheckbox(true)
                .clickSearchButtonAfterSearch();
        Assert.assertEquals(searchResultPage.getFirstSearchResultFragment().getName(), expectedResultIPod,
                expectedResultIPod + " wasn't found in search result");
    }
}
