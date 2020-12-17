package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;

public class CheckCantOpenEmptyCart extends BaseConfigurationTest {
    @Test(description = "***CantOpenEmptyCart***\n" +
            "EPMFARMATS-13173: Check that user can't open empty cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13173")
    public void checkCantOpenEmptyCart() {
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        cartButtonFragment.clickCartButton();
        String messageFromCart = cartButtonFragment.getCartDropDownEmptyMessage();

        Assert.assertEquals(messageFromCart, "Your shopping cart is empty!", "Messages aren't equals");
    }
}
