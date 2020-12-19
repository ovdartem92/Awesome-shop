package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CheckProductNameAndCostAreTheSameInCart extends BaseConfigurationTest {
    @Test(description = "***ProductNameAndCostAreTheSameInCart***\n" +
            "EPMFARMATS-13174: Check that product name and cost stay the same in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13174")
    public void checkProductNameAndCost() {
        HomePage homePage = new HomePage();
        CartTotalPopup cartTotalPopup = new CartTotalPopup();
        CartPage cartPage = new CartPage();
        String nameFromHomePage = homePage.getAllProducts().get(0).getProductName();
        String priceFromHomePage = homePage.getAllProducts().get(0).getProductPrice();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        String nameProductInCart = cartPage.getAllCartItems().get(0).getCartItemName();
        String priceProductInCart = cartPage.getAllCartItems().get(0).getCartItemUnitPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameProductInCart, nameFromHomePage, "The names of product aren't equals!");
        softAssert.assertEquals(priceProductInCart, priceFromHomePage, "The costs of product aren't equals!");
        softAssert.assertAll();
    }
}
