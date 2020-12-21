import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.product.pages.CartPage;
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
        homePage.clickAddProductToCartButtonByName(IPHONE);
        String productNameFromHomePage = homePage.getProductNameByName(IPHONE);
        CartPage cartPage = homePage.clickCartTotalButton()
                .clickViewCartButton();
        String productNameFromCart = cartPage.getItemNameByName(productNameFromHomePage);

        Assert.assertEquals(productNameFromCart, productNameFromHomePage, "The values of product aren't equal!");
    }

    @Test(description = "***CanAddMoreThanOneProductToCart***\n" +
            "EPMFARMATS-13150: Check that user can add more than one product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13150")
    public void checkAddToCartMoreProducts() {
        homePage.clickAddProductToCartButtonByName(IPHONE);
        homePage.clickAddProductToCartButtonByName(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton()
                .clickViewCartButton();
        int cartItems = cartPage.getSizeOfCartItemsList();

        Assert.assertTrue(cartItems > 1, "The size of products list isn't more 1! ");
    }

    @Test(description = "***CanChangeQuantity***\n" +
            "EPMFARMATS-13147: Check that user can change product quantity in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13147")
    public void checkCanChangeQuantity() {
        int QUANTITY = 3;
        homePage.clickAddProductToCartButtonByName(IPHONE);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.typeItemQuantityByName(IPHONE, QUANTITY);
        cartPage.clickUpdateItemButtonByName(IPHONE);
        int quantityResult = cartPage.getItemQuantityValueByName(IPHONE);

        Assert.assertEquals(quantityResult, QUANTITY, "The values of quantity aren't equals!");
    }

    @Test(description = "***CanChangeQuantityAndBuy***\n" +
            "EPMFARMATS-13149: Check that user can buy when product quantity less than 1001\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13149")
    public void checkCanBuyLess1001() {
        int QUANTITY = 666;
        homePage.clickAddProductToCartButtonByName(IPHONE);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.typeItemQuantityByName(IPHONE, QUANTITY);
        cartPage.clickUpdateItemButtonByName(IPHONE);
        cartPage.clickCheckoutButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }

    @Test(description = "***CantBuyItemsOver1000Quantity***\n" +
            "EPMFARMATS-13148: Check that user can't buy when product quantity more than 1000\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13148")
    public void checkCantBuyOver1000() {
        int QUANTITY = 1001;
        homePage.clickAddProductToCartButtonByName(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.typeItemQuantityByName(MACBOOK, QUANTITY);
        cartPage.clickUpdateItemButtonByName(MACBOOK);
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
        homePage.clickAddProductToCartButtonByName(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.typeItemQuantityByName(MACBOOK, QUANTITY);
        cartPage.clickUpdateItemButtonByName(MACBOOK);
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
        homePage.clickAddProductToCartButtonByName(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.clickRemoveItemFromCartByName(MACBOOK);
        cartPage.clickContinueButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }

    @Test(description = "***CorrectWorkContinueShoppingButton***\n" +
            "EPMFARMATS-13175: Check that 'Continue shopping' button in cart page work correctly\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13175")
    public void checkCorrectContinueShopping() {
        homePage.clickAddProductToCartButtonByName(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton().
                clickViewCartButton();
        cartPage.clickContinueShoppingButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }

    @Test(description = "***ProductNameAndCostAreTheSameInCart***\n" +
            "EPMFARMATS-13174: Check that product name and cost stay the same in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13174")
    public void checkProductNameAndCost() {
        String nameFromHomePage = homePage.getProductNameByName(IPHONE);
        String priceFromHomePage = homePage.getProductPriceByName(IPHONE);
        homePage.clickAddProductToCartButtonByName(IPHONE);
        CartPage cartPage = homePage.clickCartTotalButton()
                .clickViewCartButton();
        String nameProductInCart = cartPage.getItemNameByName(IPHONE);
        String priceProductInCart = cartPage.getItemUnitPriceByName(IPHONE);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameProductInCart, nameFromHomePage, "The names of product aren't equals!");
        softAssert.assertEquals(priceProductInCart, priceFromHomePage, "The costs of product aren't equals!");
        softAssert.assertAll();
    }

    @Test(description = "***RemoveProductFromCart***\n" +
            "EPMFARMATS-13146: Check that user can remove product from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13146")
    public void removeProduct() {
        homePage.clickAddProductToCartButtonByName(MACBOOK);
        CartPage cartPage = homePage.clickCartTotalButton()
                .clickViewCartButton();
        cartPage.clickRemoveItemFromCartByName(MACBOOK);
        String messageEmptyCart = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(messageEmptyCart, "Your shopping cart is empty!",
                "Message isn't displayed after removing product from cart!");
    }
}
