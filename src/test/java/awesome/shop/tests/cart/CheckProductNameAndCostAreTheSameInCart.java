package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;

public class CheckProductNameAndCostAreTheSameInCart extends BaseConfigurationTest {
    @Test(description = "***ProductNameAndCostAreTheSameInCart***\n" +
            "EPMFARMATS-13174: Check that product name and cost stay the same in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13174")
    public void checkProductNameAndCost() {
        HomePage homePage = new HomePage();
        homePage.getProductsList().get(0).clickAddToCartButton();
        String nameFromHomePage = homePage.getProductsList().get(0).getProductNameFromArea();
        String priceFromHomePage = homePage.getProductsList().get(0).getProductPriceFromArea();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        cartButtonFragment.clickCartButtonContainsProducts();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        String nameProductInCart = cartPage.getAllCartItemsList().get(0).getCartItemName();
        String priceProductInCart = cartPage.getAllCartItemsList().get(0).getCartItemUnitPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameProductInCart, nameFromHomePage, "The names of product aren't equals!");
        softAssert.assertEquals(priceProductInCart, priceFromHomePage, "The costs of product aren't equals!");
        softAssert.assertAll();
    }
}
