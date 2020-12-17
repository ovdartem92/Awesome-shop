import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckCantBuyItemsOver1000Quantity extends BaseConfigurationTest {
    @Test(description = "***CantBuyItemsOver1000Quantity***\n" +
            "EPMFARMATS-13148: Check that user can't buy when product quantity more than 1000\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13148")
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
