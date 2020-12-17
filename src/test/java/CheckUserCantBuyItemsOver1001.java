import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckUserCantBuyItemsOver1001 extends BaseConfigurationTest {
    @Test
    public void checkCantBuyOver1000() {
        String MACBOOK = "MacBook";
        int QUANTITY = 1001;
        SearchPanelFragment searchPanelFragment = new SearchPanelFragment();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        searchPanelFragment.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.getAllCartItemsList().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItemsList().get(0).clickCartItemUpdateButton();
        cartPage.clickCheckoutButtonExpectingFailure();
        String warningQuantityMessage = cartPage.getQuantityWarningMessage();

        Assert.assertEquals(warningQuantityMessage,
                "Products marked with *** are not available in the desired quantity or not in stock!\n" + "×",
                "There is no warning about quantity on page!");
    }
}
