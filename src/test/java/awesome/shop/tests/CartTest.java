package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.product.pages.*;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;
import ru.awesome.shop.ta.product.service.CartService;
import ru.awesome.shop.ta.product.service.NavigationService;

public class CartTest extends BaseConfigurationTest {
    private NavigationService navigationService = new NavigationService();
    private CartService cartService = new CartService();
    private HomePage homePage = new HomePage();
    private CartPage cartPage = new CartPage();
    private PhonesCatalogPage phonesCatalogPage = new PhonesCatalogPage();
    private LaptopsCatalogPage laptopsCatalogPage = new LaptopsCatalogPage();
    private String IPHONE = "iPhone";
    private String MACBOOK = "MacBook";

    @Test(description = "***CanAddItemIntoCart***\n" +
            "EPMFARMATS-13145: Check that user can add product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13145")
    public void checkItemIntoCart() {
        navigationService.navigateToPhonesCatalogPage();
        phonesCatalogPage.clickAddPhoneToCartButton(IPHONE);
        navigationService.navigateToCartPage();
        String productNameFromCart = cartService.getProductName(IPHONE);

        Assert.assertEquals(productNameFromCart, IPHONE, "The products names aren't equal!");
    }

    @Test(description = "***CanAddMoreThanOneProductToCart***\n" +
            "EPMFARMATS-13150: Check that user can add more than one product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13150")
    public void checkAddToCartMoreThanOneProduct() {
        navigationService.navigateToLaptopsCatalogPage();
        laptopsCatalogPage.clickAddLaptopToCartButton(MACBOOK);
        navigationService.navigateToPhonesCatalogPage();
        phonesCatalogPage.clickAddPhoneToCartButton(IPHONE);
        navigationService.navigateToCartPage();
        int numberOfItemsIntoCart = cartService.getNumberOfProducts();

        Assert.assertTrue(numberOfItemsIntoCart > 1, "The size of products list isn't more 1! ");
    }

    @Test(description = "***CanChangeQuantity***\n" +
            "EPMFARMATS-13147: Check that user can change product quantity in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13147")
    public void checkCanChangeQuantity() {
        int INPUT_ITEM_QUANTITY = 3;
        navigationService.navigateToPhonesCatalogPage();
        phonesCatalogPage.clickAddPhoneToCartButton(IPHONE);
        navigationService.navigateToCartPage();
        cartService.updateProductQuantity(IPHONE, INPUT_ITEM_QUANTITY);
        int quantityResult = cartService.getProductQuantity(IPHONE);

        Assert.assertEquals(quantityResult, INPUT_ITEM_QUANTITY, "The values of quantity aren't equals!");
    }

    @Test(description = "***CanChangeLessUpperLimitQuantityAndBuy***\n" +
            "EPMFARMATS-13149: Check that user can buy when product quantity less upper limit for this product\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13149")
    public void checkCanBuyLessUpperLimit() {
        int UPPER_LIMIT_IPHONE_QUANTITY = 793;
        navigationService.navigateToPhonesCatalogPage();
        phonesCatalogPage.clickAddPhoneToCartButton(IPHONE);
        navigationService.navigateToCartPage();
        cartService.updateProductQuantity(IPHONE, UPPER_LIMIT_IPHONE_QUANTITY);
        cartPage.clickCheckoutButton();
        String finishPageTitle = new CheckoutPage().getPageTitle();

        Assert.assertEquals(finishPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }

    @Test(description = "***CantBuyItemsOverUpperLimitQuantity***\n" +
            "EPMFARMATS-13148: Check that user can't buy when product quantity more than upper limit for this product\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13148")
    public void checkCantBuyOverUpperLimit() {
        int OVER_UPPER_LIMIT_MACBOOK_QUANTITY = 925;
        navigationService.navigateToLaptopsCatalogPage();
        laptopsCatalogPage.clickAddLaptopToCartButton(MACBOOK);
        navigationService.navigateToCartPage();
        cartService.updateProductQuantity(MACBOOK, OVER_UPPER_LIMIT_MACBOOK_QUANTITY);
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
        navigationService.navigateToLaptopsCatalogPage();
        laptopsCatalogPage.clickAddLaptopToCartButton(MACBOOK);
        navigationService.navigateToCartPage();
        cartService.updateProductQuantity(MACBOOK, INPUT_ITEM_QUANTITY);
        String emptyCartMessage = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty!", "Message isn't displayed after update!");
    }

    @Test(description = "***CantOpenEmptyCart***\n" +
            "EPMFARMATS-13173: Check that user can't open empty cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13173")
    public void checkCantOpenEmptyCart() {
        navigationService.navigateToLaptopsCatalogPage();
        CartTotalPopup cartTotalPopup = laptopsCatalogPage.clickCartTotalButton();
        String messageFromPopup = cartTotalPopup.getEmptyCartMessage();

        Assert.assertEquals(messageFromPopup, "Your shopping cart is empty!", "Messages aren't equals");
    }

    @Test(description = "***ContinueButtonNavigateToHomePageAfterRemove***\n" +
            "EPMFARMATS-13151: Check that 'Continue' button in empty cart lead to main page\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13151")
    public void checkContinueNavigateToHomePageAfterRemove() {
        navigationService.navigateToHomePage();
        String homePageTitle = homePage.getPageTitle();
        navigationService.navigateToLaptopsCatalogPage();
        laptopsCatalogPage.clickAddLaptopToCartButton(MACBOOK);
        navigationService.navigateToCartPage();
        cartService.deleteProduct(MACBOOK);
        String finishPageTitle = cartPage.clickContinueButton().getPageTitle();

        Assert.assertEquals(finishPageTitle, homePageTitle, "There is no Home Page in the end!");
    }

    @Test(description = "***CorrectWorkContinueShoppingButton***\n" +
            "EPMFARMATS-13175: Check that 'Continue shopping' button in cart page work correctly\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13175")
    public void checkCorrectContinueShopping() {
        navigationService.navigateToHomePage();
        String homePageTitle = homePage.getPageTitle();
        navigationService.navigateToLaptopsCatalogPage();
        laptopsCatalogPage.clickAddLaptopToCartButton(MACBOOK);
        navigationService.navigateToCartPage();
        String finishPageTitle = cartPage.clickContinueShoppingButton().getPageTitle();

        Assert.assertEquals(finishPageTitle, homePageTitle, "There is no Home Page in the end!");
    }

    @Test(description = "***ProductNameAndCostAreTheSameInCart***\n" +
            "EPMFARMATS-13174: Check that product name and cost stay the same in cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13174")
    public void checkProductNameAndCost() {
        navigationService.navigateToPhonesCatalogPage();
        phonesCatalogPage.clickAddPhoneToCartButton(IPHONE);
        String phoneNameFromCatalog = phonesCatalogPage.getPhoneName(IPHONE);
        String phonePriceFromCatalog = phonesCatalogPage.getPhonePrice(IPHONE);
        navigationService.navigateToCartPage();
        String nameProductFromCart = cartService.getProductName(IPHONE);
        String priceProductFromCart = cartService.getProductPrice(IPHONE);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(phoneNameFromCatalog, nameProductFromCart, "The names of product aren't equals!");
        softAssert.assertEquals(phonePriceFromCatalog, priceProductFromCart, "The costs of product aren't equals!");
        softAssert.assertAll();
    }

    @Test(description = "***RemoveProductFromCart***\n" +
            "EPMFARMATS-13146: Check that user can remove product from cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13146")
    public void checkCanRemoveProduct() {
        navigationService.navigateToLaptopsCatalogPage();
        laptopsCatalogPage.open();
        laptopsCatalogPage.clickAddLaptopToCartButton(MACBOOK);
        navigationService.navigateToCartPage();
        cartService.deleteProduct(MACBOOK);
        String messageEmptyCart = cartPage.getEmptyShoppingCartMessage();

        Assert.assertEquals(messageEmptyCart, "Your shopping cart is empty!",
                "Message isn't displayed after removing product from cart!");
    }
}
