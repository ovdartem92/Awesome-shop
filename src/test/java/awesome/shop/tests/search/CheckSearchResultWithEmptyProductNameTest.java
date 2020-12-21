//package awesome.shop.tests.search;
//
//import awesome.shop.tests.BaseConfigurationTest;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import ru.awesome.shop.ta.product.pages.SearchResultPage;
//
//public class CheckSearchResultWithEmptyProductNameTest extends BaseConfigurationTest {
//
//    @BeforeMethod(description = "clear search bar, click to the search button")
//    public void preparingForTheTest() {
//        searchPage = new SearchResultPage()
//                .typeSearchQuery("")
//                .clickSearchButton();
//    }
//
//    @Test(description = "***SearchResultWithEmptyProductName***\n" +
//            "EPMFARMATS-13123: check the search result for an empty product name.\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13123")
//    public void checkTheSearchResultForAnEmptyProductName() {
//        String expectedResult = "There is no product that matches the search criteria.";
//        Assert.assertEquals(searchPage.getIncorrectSearchCriteriaMessage(), expectedResult,
//                expectedResult + " is not displayed.");
//    }
//}
