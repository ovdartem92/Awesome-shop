package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;

public class CheckCanChangeQuantity extends BaseConfigurationTest {
    @Test(description = "***CanChangeQuantity***\n" +
            "EPMFARMATS-13147: Check that user can change product quantity in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13147")
    public void checkCanChangeQuantity() {
        int QUANTITY = 3;
        new HomePage().getProductsList().get(0).clickAddToCartButton();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.getAllCartItemsList().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItemsList().get(0).clickCartItemUpdateButton();
        int textQuantity = cartPage.getAllCartItemsList().get(0).getCartItemQuantityValue();

        Assert.assertEquals(textQuantity, QUANTITY, "The values of quantity aren't equals!");
    }
}
