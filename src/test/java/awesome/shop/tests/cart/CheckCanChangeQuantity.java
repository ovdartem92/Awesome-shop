package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CheckCanChangeQuantity extends BaseConfigurationTest {
    @Test(description = "***CanChangeQuantity***\n" +
            "EPMFARMATS-13147: Check that user can change product quantity in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13147")
    public void checkCanChangeQuantity() {
        int QUANTITY = 3;
        HomePage homePage = new HomePage();
        CartTotalPopup cartTotalPopup = new CartTotalPopup();
        CartPage cartPage = new CartPage();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.getAllCartItems().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItems().get(0).clickCartItemUpdateButton();
        int quantityResult = cartPage.getAllCartItems().get(0).getCartItemQuantityValue();

        Assert.assertEquals(quantityResult, QUANTITY, "The values of quantity aren't equals!");
    }
}
