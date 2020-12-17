import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckProductNameAndCostAreTheSameInCart extends BaseConfigurationTest {
    @Test(description = "***ProductNameAndCostAreTheSameInCart***\n" +
            "EPMFARMATS-13174: Check that product name and cost stay the same in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13174")
    public void checkProductNameAndCost() {
        String IPHONE = "Iphone";
        SearchPanelFragment searchPanelFragment = new SearchPanelFragment();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        searchPanelFragment.typeProductName(IPHONE);
        SearchResultsPage searchResultsPage = searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        String nameFromSearchPage = searchResultsPage.getSearchResultsList().get(0).getProductNameFromArea();
        String priceFromSearchPage = searchResultsPage.getSearchResultsList().get(0).getProductPriceFromArea();
        cartButtonFragment.clickCartButtonContainsProducts();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        String nameProductInCart = cartPage.getAllCartItemsList().get(0).getCartItemName();
        String priceProductInCart = cartPage.getAllCartItemsList().get(0).getCartItemUnitPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameProductInCart, nameFromSearchPage, "The names of product aren't equals!");
        softAssert.assertEquals(priceProductInCart, priceFromSearchPage, "The costs of product aren't equals!");
        softAssert.assertAll();
    }
}
