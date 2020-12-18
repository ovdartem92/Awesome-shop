package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;

public class CheckCantBuyZeroItems extends BaseConfigurationTest {
    @Test(description = "***CantBuyZeroItems***\n" +
            "EPMFARMATS-13178: Check that when user set quantity less than or equal to 0 product is removed from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13178")
    public void checkCantBuyZero() {
        int QUANTITY = 0;
        new HomePage().getAllProducts().get(1).clickAddToCartButton();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.getAllCartItems().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItems().get(0).clickCartItemUpdateButton();
        String emptyCartMessage = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty!", "Message isn't displayed after update!");
    }
}
