import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckRemoveProductFromCart extends BaseTest {
    @Test
    public void removeProduct() {
        String MACBOOK = "MacBook";
        SearchFragment searchPanel = new SearchFragment(driver);
        CartFragment cartPanel = new CartFragment(driver);
        searchPanel.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        cartPage.clickRemoveProductButton();
        Boolean messageEmptyCartDisplayed = cartPage.getEmptyShoppingCartMessage();

        Assert.assertTrue(messageEmptyCartDisplayed, "Message isn't displayed after removing product from cart!");
    }
}
