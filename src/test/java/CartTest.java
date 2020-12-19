import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CartTest extends BaseConfigurationTest{
    HomePage homePage = new HomePage();
    CartTotalPopup cartTotalPopup = new CartTotalPopup();
    CartPage cartPage = new CartPage();

    @Test(description = "***CanAddItemIntoCart***\n" +
            "EPMFARMATS-13145: Check that user can add product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13145")
    public void checkItemIntoCart() {
        homePage.open();
        String productNameFromHomePage = homePage.getAllProducts().get(0).getProductName();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        String productNameFromCart = cartPage.getAllCartItems().get(0).getCartItemName();

        Assert.assertEquals(productNameFromCart, productNameFromHomePage, "The values of product aren't equal!");
    }

    @Test(description = "***CanAddMoreThanOneProductToCart***\n" +
            "EPMFARMATS-13150: Check that user can add more than one product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13150")
    public void checkAddToCartMoreProducts() {
        homePage.open();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.getAllProducts().get(1).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        int sizeOfProductsList = cartPage.getAllCartItems().size();

        Assert.assertTrue(sizeOfProductsList > 1, "The size of products list isn't more 1! ");
    }

    @Test(description = "***CanChangeQuantity***\n" +
            "EPMFARMATS-13147: Check that user can change product quantity in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13147")
    public void checkCanChangeQuantity() {
        int QUANTITY = 3;
        homePage.open();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.getAllCartItems().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItems().get(0).clickCartItemUpdateButton();
        int quantityResult = cartPage.getAllCartItems().get(0).getCartItemQuantityValue();

        Assert.assertEquals(quantityResult, QUANTITY, "The values of quantity aren't equals!");
    }

    @Test(description = "***CanChangeQuantityAndBuy***\n" +
            "EPMFARMATS-13149: Check that user can buy when product quantity less than 1001\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13149")
    public void checkCanBuyLess1001() {
        int QUANTITY = 666;
        homePage.open();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.getAllCartItems().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItems().get(0).clickCartItemUpdateButton();
        cartPage.clickCheckoutButton();
        String finishPageTitle = browser.getPageTitle();
        Assert.assertEquals(finishPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }

    @Test(description = "***CantBuyItemsOver1000Quantity***\n" +
            "EPMFARMATS-13148: Check that user can't buy when product quantity more than 1000\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13148")
    public void checkCantBuyOver1000() {
        int QUANTITY = 1001;
        homePage.open();
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

    @Test(description = "***CantBuyZeroItems***\n" +
            "EPMFARMATS-13178: Check that when user set quantity less than or equal to 0 product is removed from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13178")
    public void checkCantBuyZero() {
        int QUANTITY = 0;
        homePage.open();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.getAllCartItems().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.getAllCartItems().get(0).clickCartItemUpdateButton();
        String emptyCartMessage = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty!", "Message isn't displayed after update!");
    }

    @Test(description = "***CantOpenEmptyCart***\n" +
            "EPMFARMATS-13173: Check that user can't open empty cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13173")
    public void checkCantOpenEmptyCart() {
        homePage.open();
        homePage.clickCartTotalButton();
        String messageFromPopup = cartTotalPopup.getCartDropDownEmptyMessage();

        Assert.assertEquals(messageFromPopup, "Your shopping cart is empty!", "Messages aren't equals");
    }

    @Test(description = "***ContinueButtonNavigateToHomePage***\n" +
            "EPMFARMATS-13151: Check that 'Continue' button in empty cart lead to main page\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13151")
    public void continueNavigateToHomePage() {
        homePage.open();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.getAllCartItems().get(0).clickCartItemRemoveButton();
        cartPage.clickContinueButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }

    @Test(description = "***CorrectWorkContinueShoppingButton***\n" +
            "EPMFARMATS-13175: Check that 'Continue shopping' button in cart page work correctly\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13175")
    public void checkCorrectContinueShopping() {
        homePage.open();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.clickContinueShoppingButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }

    @Test(description = "***ProductNameAndCostAreTheSameInCart***\n" +
            "EPMFARMATS-13174: Check that product name and cost stay the same in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13174")
    public void checkProductNameAndCost() {
        homePage.open();
        String nameFromHomePage = homePage.getAllProducts().get(0).getProductName();
        String priceFromHomePage = homePage.getAllProducts().get(0).getProductPrice();
        homePage.getAllProducts().get(0).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        String nameProductInCart = cartPage.getAllCartItems().get(0).getCartItemName();
        String priceProductInCart = cartPage.getAllCartItems().get(0).getCartItemUnitPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameProductInCart, nameFromHomePage, "The names of product aren't equals!");
        softAssert.assertEquals(priceProductInCart, priceFromHomePage, "The costs of product aren't equals!");
        softAssert.assertAll();
    }

    @Test(description = "***RemoveProductFromCart***\n" +
            "EPMFARMATS-13146: Check that user can remove product from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13146")
    public void removeProduct() {
        homePage.open();
        homePage.getAllProducts().get(1).clickAddToCartButton();
        homePage.clickCartTotalButton();
        cartTotalPopup.clickViewCartButton();
        cartPage.getAllCartItems().get(0).clickCartItemRemoveButton();
        String messageEmptyCart = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(messageEmptyCart, "Your shopping cart is empty!",
                "Message isn't displayed after removing product from cart!");
    }
}
