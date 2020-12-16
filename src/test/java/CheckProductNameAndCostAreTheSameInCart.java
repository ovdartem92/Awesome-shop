import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.CartPanel;
import ru.awesome.shop.ta.product.pages.SearchPanel;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckProductNameAndCostAreTheSameInCart extends BaseTest {
    @Test
    public void checkProductNameAndCost() {
        String IPHONE = "Iphone";
        SearchPanel searchPanel = new SearchPanel(driver);
        CartPanel cartPanel = new CartPanel(driver);
        searchPanel.clearAndTypeProductNameToSearchField(IPHONE);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCart();
        String nameFromThumb = searchResultsPage.getProductNameFromThumb();
        String costFromThumb = searchResultsPage.getProductCostFromThumb();
        cartPanel.clickCartButtonContainsProducts();
        CartPage cartPage = cartPanel.clickViewCartButton();
        String nameProductInCart = cartPage.getProductNameIntoCart();
        String priceProductInCart = cartPage.getProductUnitPriceIntoCart();

        Assert.assertEquals(nameProductInCart, nameFromThumb, "The names of product aren't equals!");
        Assert.assertEquals(priceProductInCart, costFromThumb, "The costs of product aren't equals!");
    }
}
