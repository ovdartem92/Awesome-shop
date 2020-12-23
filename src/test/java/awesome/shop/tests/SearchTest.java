package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.services.SearchService;

public class SearchTest extends BaseConfigurationTest {
    SearchService searchService = new SearchService();

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
                {"Classic iPod"},
                {"Class Pod"},
                {"iPod Classic"},
                {"iPo"},
                {"IPOD"},
        };
    }

    @Test(description = "***NegativeSearchResultTests***\n" +
            "EPMFARMATS-13136: check the search field for XSS attacks\n" +
            "EPMFARMATS-13129: check the search result for a non-existent product\n" +
            "EPMFARMATS-13137: checks the search result when typing a space.\n" +
            "EPMFARMATS-13123: check the search result for an empty product name.\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13136\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13129\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13137\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13123\n",
            dataProvider = "negativeSearchData", groups = "negative")
    public void checkTheSearchFieldByNegativeSearchData(String searchData) {
        String expectedResult = "There is no product that matches the search criteria.";
        searchService.openHomePageTypeDataToSearchClickSearchButton(searchData);
        Assert.assertEquals
                (searchService.getCheckedIncorrectSearchCriteriaMessage(), expectedResult,
                        expectedResult + " is not displayed.");
    }

    @Test(description = "***PositiveSearchResultTests***\n" +
            "EPMFARMATS-13133: check the search result for the full product name in uppercase\n" +
            "EPMFARMATS-13130: check the search result for a word part of an existing product\n" +
            "EPMFARMATS-13128: check the search result for an existing product by full name\n" +
            "EPMFARMATS-13132: check the search result by part of words in reverse order\n" +
            "EPMFARMATS-13131: check the search result by full product name in reverse order\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13133\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13130\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13128\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13132\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13131\n",
            dataProvider = "positiveSearchData", groups = "positive")
    public void checkTheSearchFieldByPositiveSearchData(String searchData) {
        String expectedResult = "iPod Classic";
        searchService.openHomePageTypeDataToSearchClickSearchButton(searchData);
        Assert.assertEquals(searchService.getFirstActualSearchFragment().getName(), expectedResult,
                expectedResult + " is not displayed.");
    }

    @Test(description = "***SearchResultByPressingTheEnter***\n" +
            "EPMFARMATS-13138: check the search result by pressing the enter key\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13138", groups = "positive")
    public void checkTheSearchResultByPressingTheEnterKey() {
        String expectedResult = "iPod Classic";
        String iPod = "iPod";
        String enter = "\n";
        searchService.openHomePageTypeDataToSearch(iPod + enter);
        Assert.assertEquals(searchService.getFirstActualSearchFragment().getName(), expectedResult,
                expectedResult + " wasn't found in search result");
    }

    @Test(description = "***SearchResultByProductCategory***\n" +
            "EPMFARMATS-13135: check the search result by product category\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13135", groups = "positive")
    public void checkTheSearchResultByProductCategory() {
        String expectedResult = "iMac";
        String iMacCategory = "      Mac";
        searchService.openHomePageTypeDataToSearchClickSearchButtonSelectCategory(expectedResult,
                iMacCategory);
        Assert.assertEquals(searchService.getFirstActualSearchFragment().getName(), expectedResult,
                expectedResult + " wasn't found in search result");
    }

    @Test(description = "***SearchResultByProductDescription***\n" +
            "EPMFARMATS-13134: check the search result by product description\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13134", groups = "positive")
    public void checkTheSearchResultByProductDescription() {
        String expectedResult = "iPod Classic";
        searchService.openHomePageTypeDataToSearchClickSearchButtonSetDescription(expectedResult);
        Assert.assertEquals(searchService.getFirstActualSearchFragment().getName(), expectedResult,
                expectedResult + " wasn't found in search result");
    }
}
