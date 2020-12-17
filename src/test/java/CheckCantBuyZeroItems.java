import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckCantBuyZeroItems extends BaseConfigurationTest {
    @Test(description = "***CantBuyZeroItems***\n" +
            "EPMFARMATS-13178: Check that when user set quantity less than or equal to 0 product is removed from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13178")
    public void checkCantBuyZero() {
        String MACBOOK = "MacBook";
        int QUANTITY = 0;
        SearchPanelFragment searchPanelFragment = new SearchPanelFragment();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        searchPanelFragment.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.getAllCartItemsList().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItemsList().get(0).clickCartItemUpdateButton();
        String emptyCartMessage = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty!", "Message isn't displayed after update!");
    }
}
