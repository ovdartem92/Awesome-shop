import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckUserCantBuyZeroItems extends BaseTest {
    @Test
    public void checkCantBuyZero() {
        String MACBOOK = "MacBook";
        String QUANTITY = "0";
        SearchFragment searchPanel = new SearchFragment(driver);
        CartFragment cartPanel = new CartFragment(driver);
        searchPanel.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        cartPage.typeQuantity(QUANTITY);
        cartPage.clickUpdateProductButton();
        Boolean messageEmptyCartDisplayed = cartPage.getEmptyShoppingCartMessage();

        Assert.assertTrue(messageEmptyCartDisplayed, "Message isn't displayed after update!");
    }
}
