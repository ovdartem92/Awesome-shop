import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckProductNameAndCostAreTheSameInCart extends BaseTest{
    @Test
    public void checkProductNameAndCost(){
        String IPHONE = "Iphone";
        SearchResultsPage searchResultsPage = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(IPHONE)
                .clickSearchButton()
                .clickAddToCart();
        String nameFromThumb = searchResultsPage.getProductNameFromThumb();
        String costFromThumb = searchResultsPage.getProductCostFromThumb();
        CartPage cartPage = searchResultsPage
                .clickCartButton()
                .clickViewCartButton();
        String nameProductInCart = cartPage.getProductNameIntoCart();
        String priceProductInCart = cartPage.getProductUnitPriceIntoCart();

        Assert.assertEquals(nameProductInCart, nameFromThumb, "The names of product aren't equals!");
        Assert.assertEquals(priceProductInCart, costFromThumb, "The costs of product aren't equals!");

    }
}
