package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CheckCanAddItemIntoCartTest extends BaseConfigurationTest {
    @Test(description = "***CanAddItemIntoCart***\n" +
            "EPMFARMATS-13145: Check that user can add product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13145")
    public void checkItemIntoCart() {
        HomePage homePage = new HomePage();
        CartTotalPopup cartTotalPopup = new CartTotalPopup();
        CartPage cartPage = new CartPage();
        String productNameFromHomePage = homePage.getAllProducts().get(0).getProductName();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        String productNameFromCart = cartPage.getAllCartItems().get(0).getCartItemName();

        Assert.assertEquals(productNameFromCart, productNameFromHomePage, "The values of product aren't equal!");
    }
}
