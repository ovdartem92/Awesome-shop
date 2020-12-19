package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CheckCanChangeQuantityLess1001AndBuy extends BaseConfigurationTest {
    @Test(description = "***CanChangeQuantityAndBuy***\n" +
            "EPMFARMATS-13149: Check that user can buy when product quantity less than 1001\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13149")
    public void checkCanBuyLess10001() {
        int QUANTITY = 666;
        HomePage homePage = new HomePage();
        CartTotalPopup cartTotalPopup = new CartTotalPopup();
        CartPage cartPage = new CartPage();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.getAllCartItems().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItems().get(0).clickCartItemUpdateButton();
        cartPage.clickCheckoutButton();
        String finishPageTitle = browser.getPageTitle();
        Assert.assertEquals(finishPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }
}
