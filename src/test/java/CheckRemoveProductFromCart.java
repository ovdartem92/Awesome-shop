import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.CartPanel;
import ru.awesome.shop.ta.product.pages.SearchPanel;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckRemoveProductFromCart extends BaseTest {
    @Test
    public void removeProduct() {
        String MACBOOK = "MacBook";
        SearchPanel searchPanel = new SearchPanel(driver);
        CartPanel cartPanel = new CartPanel(driver);
        searchPanel.clearAndTypeProductNameToSearchField(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCart();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        cartPage.clickRemoveProductButton();
        Boolean messageEmptyCartDisplayed = cartPage.isEmptyShoppingCartMessageDisplayed();

        Assert.assertTrue(messageEmptyCartDisplayed, "Message isn't displayed after removing product from cart!");
    }
}
