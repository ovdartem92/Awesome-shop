package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;

public class CheckRemoveProductFromCart extends BaseConfigurationTest {
    @Test(description = "***RemoveProductFromCart***\n" +
            "EPMFARMATS-13146: Check that user can remove product from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13146")
    public void removeProduct() {
        new HomePage().getAllProducts().get(1).clickAddToCartButton();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.getAllCartItems().get(0).clickCartItemRemoveButton();
        String messageEmptyCart = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(messageEmptyCart, "Your shopping cart is empty!",
                "Message isn't displayed after removing product from cart!");
    }
}
