package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.exceptions.IncorrectSearchCriteriaException;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.SearchResultPage;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;
import ru.awesome.shop.ta.product.services.NavigationService;
import ru.awesome.shop.ta.product.services.SearchService;

import java.util.List;

public class SearchTest extends BaseConfigurationTest {
    SearchService searchService = new SearchService();
    NavigationService navigationService = new NavigationService();

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
            dataProvider = "negativeSearchData", groups = {"all", "negative"},
            expectedExceptions = IncorrectSearchCriteriaException.class)
    public void checkTheSearchFieldByNegativeSearchData(String searchCriteria) throws IncorrectSearchCriteriaException {
        navigationService.navigateToHomePage();
        List<String> actualSearchResultsName = searchService.performAdvancedSearch(searchCriteria);
        Assert.assertTrue(actualSearchResultsName.size() < 1,
                "The search result should not be on the page.");
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
            dataProvider = "positiveSearchData", groups = {"all", "positive"})
    public void checkTheSearchFieldByPositiveSearchData(String searchCriteria) {
        String expectedResult = "iPod Classic";
        navigationService.navigateToHomePage();
        List<String> actualSearchResultsName = searchService.performBasicSearch(searchCriteria);
        Assert.assertEquals(actualSearchResultsName.get(0), expectedResult,
                expectedResult + " wasn't found in search result.");
    }

    @Test(description = "***SearchResultByPressingTheEnter***\n" +
            "EPMFARMATS-13138: check the search result by pressing the enter key\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13138", groups = {"all", "positive"})
    public void checkTheSearchResultByPressingTheEnterKey() {
        String expectedResult = "iPod Classic";
        HomePage homePage = new HomePage();
        homePage.open();
        SearchFragment searchFragment = homePage.getSearchFragment();
        searchFragment.typeSearchQuery(expectedResult);
        SearchResultPage searchResultPage = searchFragment.performSearchByPressingEnter();
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        Assert.assertEquals(searchResults.get(0).getName(), expectedResult,
                expectedResult + " wasn't found in search result.");
    }

    @Test(description = "***SearchResultByProductCategory***\n" +
            "EPMFARMATS-13135: check the search result by product category\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13135", groups = {"all", "positive"})
    public void checkTheSearchResultByProductCategory() {
        String searchCriteria = "iMac";
        navigationService.navigateToHomePage();
        List<String> actualSearchResultsName = searchService
                .performAdvancedSearch(searchCriteria, false, true);
        Assert.assertEquals(actualSearchResultsName.get(0), searchCriteria,
                searchCriteria + " wasn't found in search result.");
    }

    @Test(description = "***SearchResultByProductDescription***\n" +
            "EPMFARMATS-13134: check the search result by product description\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13134", groups = {"all", "positive"})
    public void checkTheSearchResultByProductDescription() {
        String searchCriteria = "iPod Classic";
        navigationService.navigateToHomePage();
        List<String> actualSearchResults = searchService
                .performAdvancedSearch(searchCriteria, true, false);
        Assert.assertEquals(actualSearchResults.get(0), searchCriteria,
                searchCriteria + " wasn't found in search result.");
    }
}
