//package awesome.shop.tests.search.a1;//package awesome.shop.tests.search;
//
//import awesome.shop.tests.BaseConfigurationTest;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import ru.awesome.shop.ta.product.pages.SearchResultPage;
//
//public class CheckSearchResultByPressingTheEnterKeyTest extends BaseConfigurationTest {
//
//    @BeforeMethod(description = "clear search bar, enter text by 'Enter' key")
//    public void preparingForTheTest() {
//        String enter = "\n";
//        String iPod = "iPod";
//        new SearchResultPage()
//                .typeSearchQuery(iPod + enter);
//    }
//
//    @Test(description = "***SearchResultByPressingTheEnter***\n" +
//            "EPMFARMATS-13138: check the search result by pressing the enter key\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13138")
//    public void checkTheSearchResultByPressingTheEnterKey() {
//        String expectedResult = "iPod Classic";
//        Assert.assertTrue(new SearchResultPage().isSearchResultNameContainsOnSearchList(expectedResult),
//                expectedResult + " wasn't found in search result");
//    }
//}
