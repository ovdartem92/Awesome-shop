import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckProductNameAndCostAreTheSameInCart extends BaseTest {
    @Test
    public void checkProductNameAndCost() {
        String IPHONE = "Iphone";
        SearchFragment searchPanel = new SearchFragment(driver);
        CartFragment cartPanel = new CartFragment(driver);
        searchPanel.typeProductName(IPHONE);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
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
