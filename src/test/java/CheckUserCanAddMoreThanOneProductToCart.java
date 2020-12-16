import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.CartPanel;
import ru.awesome.shop.ta.product.pages.SearchPanel;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckUserCanAddMoreThanOneProductToCart extends BaseTest {
    @Test
    public void checkAddToCartMoreProducts() {
        String MACBOOK = "MacBook";
        String IPHONE = "iPhone";
        SearchPanel searchPanel = new SearchPanel(driver);
        CartPanel cartPanel = new CartPanel(driver);
        searchPanel.clearAndTypeProductNameToSearchField(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCart();
        searchPanel.clearAndTypeProductNameToSearchField(IPHONE);
        searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCart();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        Boolean isProductListMoreThanOne = cartPage.isCartContainsMoreThanOneProduct();

        Assert.assertTrue(isProductListMoreThanOne, "The size of products list isn't more 1! ");
    }
}