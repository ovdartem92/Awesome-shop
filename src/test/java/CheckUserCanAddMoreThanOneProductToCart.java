import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;

public class CheckUserCanAddMoreThanOneProductToCart extends BaseTest {
    @Test
    public void checkAddToCartMoreProducts() {
        String MACBOOK = "MacBook";
        String IPHONE = "iPhone";
        SearchFragment searchFragment = new SearchFragment();
        CartFragment cartFragment = new CartFragment();
        searchFragment.typeProductName(IPHONE);
        SearchResultsPage searchResultsPage = searchFragment.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        searchFragment.typeProductName(MACBOOK);
        searchFragment.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartFragment.clickCartButton();
        CartPage cartPage = cartFragment.clickViewCartButton();
        int sizeOfProductsList = cartPage.getProductsListSize();

        Assert.assertTrue(sizeOfProductsList > 1, "The size of products list isn't more 1! ");
    }
}