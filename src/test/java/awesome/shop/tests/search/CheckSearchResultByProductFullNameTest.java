//package awesome.shop.tests.search;
//
//import awesome.shop.tests.BaseConfigurationTest;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import ru.awesome.shop.ta.product.pages.SearchResultPage;
//
//public class CheckSearchResultByProductFullNameTest extends BaseConfigurationTest {
//    private final String iPod = "iPod Classic";
//
//    @BeforeMethod(description = "clear search bar, enter text, click to the search button")
//    public void preparingForTheTest() {
//        searchPage = new SearchResultPage()
//                .typeSearchQuery(iPod)
//                .clickSearchButton();
//    }
//
//    @Test(description = "***SearchResultByProductFullName***\n" +
//            "EPMFARMATS-13128: check the search result for an existing product by full name\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13128")
//    public void checkTheSearchResultByFullNameProduct() {
//        Assert.assertTrue(searchPage.isSearchResultNameContainsOnSearchList(iPod),
//                iPod + " wasn't found in search result");
//    }
//}
