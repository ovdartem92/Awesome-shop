package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.CheckoutPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class CartTest extends BaseConfigurationTest {
    private HomePage homePage = new HomePage();
    private String IPHONE = "iPhone";
    private String MACBOOK = "MacBook";

    @BeforeMethod(description = "open home page")
    public void openHomePage() {
        homePage.open();
    }

    @Test(description = "***CanAddItemIntoCart***\n" +
            "EPMFARMATS-13145: Check that user can add product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13145")
    public void checkItemIntoCart() {
        String productNameFromHomePage = homePage.getProductName(IPHONE);
        homePage.clickAddProductToCartButton(IPHONE);
        CartPage cartPage = homePage.clickCartTotalButton()
                .clickViewCartButton();
        String productNameFromCart = cartPage.getItemName(productNameFromHomePage);

        Assert.assertEquals(productNameFromCart, productNameFromHomePage, "The values of product aren't equal!");
    }

    @Test(description = "***CanAddMoreThanOneProductToCart***\n" +
            "EPMFARMATS-13150: Check that user can add more than one product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13150")
    public void checkAddToCartMoreProducts() {
        homePage.clickAddProductToCartButton(IPHONE);
        homePage.clickAddProductToCartButton(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton()
                .clickViewCartButton();
        int cartItems = cartPage.getNumberOfCartItems();

        Assert.assertTrue(cartItems > 1, "The size of products list isn't more 1! ");
    }

    @Test(description = "***CanChangeQuantity***\n" +
            "EPMFARMATS-13147: Check that user can change product quantity in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13147")
    public void checkCanChangeQuantity() {
        int INPUT_ITEM_QUANTITY = 3;
        homePage.clickAddProductToCartButton(IPHONE);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.typeItemQuantity(IPHONE, INPUT_ITEM_QUANTITY);
        cartPage.clickUpdateItemButton(IPHONE);
        int quantityResult = cartPage.getItemQuantityValue(IPHONE);

        Assert.assertEquals(quantityResult, INPUT_ITEM_QUANTITY, "The values of quantity aren't equals!");
    }

    @Test(description = "***CanChangeLessUpperLimitQuantityAndBuy***\n" +
            "EPMFARMATS-13149: Check that user can buy when product quantity less upper limit for this product\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13149")
    public void checkCanBuyLessUpperLimit() {
        int UPPER_LIMIT_IPHONE_QUANTITY = 793;
        homePage.clickAddProductToCartButton(IPHONE);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.typeItemQuantity(IPHONE, UPPER_LIMIT_IPHONE_QUANTITY);
        cartPage.clickUpdateItemButton(IPHONE);
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        String finishPageTitle = checkoutPage.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }

    @Test(description = "***CantBuyItemsOverUpperLimitQuantity***\n" +
            "EPMFARMATS-13148: Check that user can't buy when product quantity more than upper limit for this product\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13148")
    public void checkCantBuyOverUpperLimit() {
        int OVER_UPPER_LIMIT_MACBOOK_QUANTITY = 925;
        homePage.clickAddProductToCartButton(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.typeItemQuantity(MACBOOK, OVER_UPPER_LIMIT_MACBOOK_QUANTITY);
        cartPage.clickUpdateItemButton(MACBOOK);
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
        int INPUT_ITEM_QUANTITY = 0;
        homePage.clickAddProductToCartButton(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.typeItemQuantity(MACBOOK, INPUT_ITEM_QUANTITY);
        cartPage.clickUpdateItemButton(MACBOOK);
        String emptyCartMessage = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty!", "Message isn't displayed after update!");
    }

    @Test(description = "***CantOpenEmptyCart***\n" +
            "EPMFARMATS-13173: Check that user can't open empty cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13173")
    public void checkCantOpenEmptyCart() {
        CartTotalPopup cartTotalPopup = homePage.clickCartTotalButton();
        String messageFromPopup = cartTotalPopup.getEmptyCartMessage();

        Assert.assertEquals(messageFromPopup, "Your shopping cart is empty!", "Messages aren't equals");
    }

    @Test(description = "***ContinueButtonNavigateToHomePage***\n" +
            "EPMFARMATS-13151: Check that 'Continue' button in empty cart lead to main page\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13151")
    public void continueNavigateToHomePage() {
        homePage.clickAddProductToCartButton(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.clickRemoveItemFromCart(MACBOOK);
        cartPage.clickContinueButton();
        String finishPageTitle = homePage.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }

    @Test(description = "***CorrectWorkContinueShoppingButton***\n" +
            "EPMFARMATS-13175: Check that 'Continue shopping' button in cart page work correctly\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13175")
    public void checkCorrectContinueShopping() {
        homePage.clickAddProductToCartButton(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.clickContinueShoppingButton();
        String finishPageTitle = homePage.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }

    @Test(description = "***ProductNameAndCostAreTheSameInCart***\n" +
            "EPMFARMATS-13174: Check that product name and cost stay the same in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13174")
    public void checkProductNameAndCost() {
        String nameFromHomePage = homePage.getProductName(IPHONE);
        String priceFromHomePage = homePage.getProductPrice(IPHONE);
        homePage.clickAddProductToCartButton(IPHONE);
        CartPage cartPage = homePage.clickCartTotalButton()
                .clickViewCartButton();
        String nameProductInCart = cartPage.getItemName(IPHONE);
        String priceProductInCart = cartPage.getItemUnitPrice(IPHONE);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameProductInCart, nameFromHomePage, "The names of product aren't equals!");
        softAssert.assertEquals(priceProductInCart, priceFromHomePage, "The costs of product aren't equals!");
        softAssert.assertAll();
    }

    @Test(description = "***RemoveProductFromCart***\n" +
            "EPMFARMATS-13146: Check that user can remove product from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13146")
    public void removeProduct() {
        homePage.clickAddProductToCartButton(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton()
                .clickViewCartButton();
        cartPage.clickRemoveItemFromCart(MACBOOK);
        String messageEmptyCart = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(messageEmptyCart, "Your shopping cart is empty!",
                "Message isn't displayed after removing product from cart!");
    }
}
