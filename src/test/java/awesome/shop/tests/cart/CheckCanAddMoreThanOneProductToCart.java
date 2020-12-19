package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CheckCanAddMoreThanOneProductToCart extends BaseConfigurationTest {
    @Test(description = "***CanAddMoreThanOneProductToCart***\n" +
            "EPMFARMATS-13150: Check that user can add more than one product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13150")
    public void checkAddToCartMoreProducts() {
        HomePage homePage = new HomePage();
        CartTotalPopup cartTotalPopup = new CartTotalPopup();
        CartPage cartPage = new CartPage();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.getAllProducts().get(1).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        int sizeOfProductsList = cartPage.getAllCartItems().size();
        System.out.println("SIZE: " + sizeOfProductsList);

        Assert.assertTrue(sizeOfProductsList > 1, "The size of products list isn't more 1! ");
    }
}