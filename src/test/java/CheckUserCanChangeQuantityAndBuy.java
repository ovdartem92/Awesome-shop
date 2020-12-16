import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;

public class CheckUserCanChangeQuantityAndBuy extends BaseTest {
    @Test
    public void checkCanBuyLess1000() {
        String MACBOOK = "MacBook";
        int QUANTITY = 666;
        SearchFragment searchFragment = new SearchFragment();
        CartFragment cartFragment = new CartFragment();
        searchFragment.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchFragment.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartFragment.clickCartButton();
        CartPage cartPage = cartFragment.clickViewCartButton();
        cartPage.typeQuantity(QUANTITY);
        cartPage.clickCheckoutButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }
}
