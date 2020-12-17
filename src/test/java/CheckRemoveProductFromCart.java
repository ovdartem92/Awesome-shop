import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckRemoveProductFromCart extends BaseConfigurationTest {
    @Test(description = "***RemoveProductFromCart***\n" +
            "EPMFARMATS-13146: Check that user can remove product from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13146")
    public void removeProduct() {
        String MACBOOK = "MacBook";
        SearchPanelFragment searchPanelFragment = new SearchPanelFragment();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        searchPanelFragment.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.getAllCartItemsList().get(0).clickCartItemRemoveButton();
        String messageEmptyCart = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(messageEmptyCart, "Your shopping cart is empty!",
                "Message isn't displayed after removing product from cart!");
    }
}
