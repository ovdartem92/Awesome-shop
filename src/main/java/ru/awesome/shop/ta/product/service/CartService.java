package ru.awesome.shop.ta.product.service;

import ru.awesome.shop.ta.product.pages.BasePage;
import ru.awesome.shop.ta.product.pages.CartPage;

public class CartService extends BasePage {
    private CartPage cartPage = new CartPage();

    public void setItemQuantity(String itemName, int itemQuantity) {
        cartPage.typeItemQuantity(itemName, itemQuantity);
        cartPage.clickUpdateItemButton(itemName);
    }

    public int setItemQuantityAndReturnValue(String itemName, int itemQuantity) {
        setItemQuantity(itemName, itemQuantity);
        return cartPage.getItemQuantityValue(itemName);
    }

    public void setItemQuantityAndClickCheckout(String itemName, int itemQuantity) {
        setItemQuantity(itemName, itemQuantity);
        cartPage.clickCheckoutButton();
    }

    public void setItemQuantityAndClickCheckoutExpectingFailure(String itemName, int itemQuantity) {
        setItemQuantity(itemName, itemQuantity);
        cartPage.clickCheckoutButtonExpectingFailure();
    }

    public void removeItemFromCartAndClickContinue(String itemName) {
        cartPage.clickRemoveItemFromCart(itemName);
        cartPage.clickContinueButton();
    }

    public void navigateToCartPage() {
        clickCartTotalButton().clickViewCartButton();
    }
}
