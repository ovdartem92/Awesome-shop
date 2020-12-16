import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckUserCanAddMoreThanOneProductToCart extends BaseTest {
    @Test
    public void checkAddToCartMoreProducts() {
        String MACBOOK = "MacBook";
        String IPHONE = "iPhone";
        SearchFragment searchPanel = new SearchFragment(driver);
        CartFragment cartPanel = new CartFragment(driver);
        searchPanel.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        searchPanel.typeProductName(IPHONE);
        searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        Boolean isProductListMoreThanOne = cartPage.isCartContainsMoreThanOneProduct();

        Assert.assertTrue(isProductListMoreThanOne, "The size of products list isn't more 1! ");
    }
}