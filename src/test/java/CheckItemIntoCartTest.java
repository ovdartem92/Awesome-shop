import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.CartPanel;
import ru.awesome.shop.ta.product.pages.SearchPanel;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckItemIntoCartTest extends BaseTest {
    @Test
    public void checkItemIntoCart() {
        String MACBOOK = "MacBook";
        SearchPanel searchPanel = new SearchPanel(driver);
        CartPanel cartPanel = new CartPanel(driver);
        searchPanel.clearAndTypeProductNameToSearchField(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCart();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        String productName = cartPage.getProductNameIntoCart();

        Assert.assertEquals(productName, MACBOOK, "The values of product aren't equal!");
    }
}
