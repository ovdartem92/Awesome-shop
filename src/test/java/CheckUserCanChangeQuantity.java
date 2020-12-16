import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckUserCanChangeQuantity extends BaseTest {
    @Test
    public void checkCantBuyZero() {
        String MACBOOK = "MacBook";
        String QUANTITY = "2";
        SearchFragment searchPanel = new SearchFragment(driver);
        CartFragment cartPanel = new CartFragment(driver);
        searchPanel.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        cartPage.typeQuantity(QUANTITY);
        cartPage.clickUpdateProductButton();
        String quantityFromCartButton = cartPanel.getQuantityFromCartButton();

        Assert.assertEquals(quantityFromCartButton, QUANTITY, "The values of quantity aren't equals!");
    }
}
