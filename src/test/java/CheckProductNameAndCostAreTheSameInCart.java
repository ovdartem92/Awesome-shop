import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;

public class CheckProductNameAndCostAreTheSameInCart extends BaseTest {
    @Test
    public void checkProductNameAndCost() {
        String IPHONE = "Iphone";
        SearchFragment searchFragment = new SearchFragment();
        CartFragment cartFragment = new CartFragment();
        searchFragment.typeProductName(IPHONE);
        SearchResultsPage searchResultsPage = searchFragment.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        String nameFromSearchPage = searchResultsPage.getProductNameFromArea();
        String priceFromSearchPage = searchResultsPage.getProductPriceFromArea();
        cartFragment.clickCartButtonContainsProducts();
        CartPage cartPage = cartFragment.clickViewCartButton();
        String nameProductInCart = cartPage.getProductNameIntoCart(1);
        String priceProductInCart = cartPage.getProductUnitPriceIntoCart();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameProductInCart, nameFromSearchPage, "The names of product aren't equals!");
        softAssert.assertEquals(priceProductInCart, priceFromSearchPage, "The costs of product aren't equals!");
        softAssert.assertAll();
    }
}
