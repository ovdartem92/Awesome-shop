package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CheckCantBuyItemsOver1000Quantity extends BaseConfigurationTest {
    @Test(description = "***CantBuyItemsOver1000Quantity***\n" +
            "EPMFARMATS-13148: Check that user can't buy when product quantity more than 1000\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13148")
    public void checkCantBuyOver1000() {
        int QUANTITY = 1001;
        HomePage homePage = new HomePage();
        CartTotalPopup cartTotalPopup = new CartTotalPopup();
        CartPage cartPage = new CartPage();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.getAllCartItems().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItems().get(0).clickCartItemUpdateButton();
        cartPage.clickCheckoutButtonExpectingFailure();
        String warningQuantityMessage = cartPage.getQuantityWarningMessage();

        Assert.assertEquals(warningQuantityMessage,
                "Products marked with *** are not available in the desired quantity or not in stock!\n" + "×",
                "There is no warning about quantity on page!");
    }
}
