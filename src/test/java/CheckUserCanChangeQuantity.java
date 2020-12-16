import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;

public class CheckUserCanChangeQuantity extends BaseTest {
    @Test
    public void checkCantBuyZero() {
        String MACBOOK = "MacBook";
        int QUANTITY = 3;
        SearchFragment searchFragment = new SearchFragment();
        CartFragment cartFragment = new CartFragment();
        searchFragment.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchFragment.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartFragment.clickCartButton();
        CartPage cartPage = cartFragment.clickViewCartButton();
        cartPage.typeQuantity(QUANTITY);
        cartPage.clickUpdateProductButton();
        int quantityFromCartButton = cartFragment.getQuantityFromCartButton();

        Assert.assertEquals(quantityFromCartButton, QUANTITY, "The values of quantity aren't equals!");
    }
}
