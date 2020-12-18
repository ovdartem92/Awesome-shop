package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;

public class CheckCanAddMoreThanOneProductToCart extends BaseConfigurationTest {
    @Test(description = "***CanAddMoreThanOneProductToCart***\n" +
            "EPMFARMATS-13150: Check that user can add more than one product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13150")
    public void checkAddToCartMoreProducts() {
        HomePage homePage = new HomePage();
        homePage.getProductsList().get(0).clickAddToCartButton();
        homePage.getProductsList().get(1).clickAddToCartButton();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        int sizeOfProductsList = cartPage.getAllCartItemsList().size();

        Assert.assertTrue(sizeOfProductsList > 1, "The size of products list isn't more 1! ");
    }
}