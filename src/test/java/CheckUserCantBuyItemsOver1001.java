import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckUserCantBuyItemsOver1001 extends BaseTest {
    @Test
    public void checkCantBuyOver1000() {
        String MACBOOK = "MacBook";
        String QUANTITY = "1001";
        SearchFragment searchPanel = new SearchFragment(driver);
        CartFragment cartPanel = new CartFragment(driver);
        searchPanel.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        cartPage.typeQuantity(QUANTITY);
        cartPage.clickUpdateProductButton();
        cartPage.clickCheckoutButtonExpectingFailure();
        Boolean warningQuantityDisplayed = cartPage.isQuantityWarningDisplayed();

        Assert.assertTrue(warningQuantityDisplayed, "There is no warning about quantity on page!");
    }
}
