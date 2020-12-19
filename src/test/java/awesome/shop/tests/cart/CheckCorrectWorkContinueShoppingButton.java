package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CheckCorrectWorkContinueShoppingButton extends BaseConfigurationTest {
    @Test(description = "***CorrectWorkContinueShoppingButton***\n" +
            "EPMFARMATS-13175: Check that 'Continue shopping' button in cart page work correctly\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13175")
    public void checkCorrectContinueShopping() {
        HomePage homePage = new HomePage();
        CartTotalPopup cartTotalPopup = new CartTotalPopup();
        CartPage cartPage = new CartPage();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.clickContinueShoppingButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }
}
