package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;

public class CheckCanAddItemIntoCartTest extends BaseConfigurationTest {
    @Test(description = "***CanAddItemIntoCart***\n" +
            "EPMFARMATS-13145: Check that user can add product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13145")
    public void checkItemIntoCart() {
        new HomePage().getProductsList().get(0).clickAddToCartButton();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        String productName = cartPage.getAllCartItemsList().get(0).getCartItemName();

        Assert.assertEquals(productName, "MacBook", "The values of product aren't equal!");
    }
}
