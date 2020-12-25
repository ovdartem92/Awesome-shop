package ru.awesome.shop.ta.product.service;

import ru.awesome.shop.ta.framework.logging.Log;
import ru.awesome.shop.ta.product.pages.BasePage;
import ru.awesome.shop.ta.product.pages.CartPage;

import java.util.List;
import java.util.Map;

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


    public void updateProducts(Map<String, Integer> productNameToQuantityMapping) {
        List<String> itemNames = getAllProductNames();
        for (Map.Entry<String, Integer> entry : productNameToQuantityMapping.entrySet()) {
            String itemNameFromMap = entry.getKey();
            int itemNewQuantity = entry.getValue();
            if (itemNames.contains(itemNameFromMap)) {
                cartPage.typeItemQuantity(itemNameFromMap, itemNewQuantity);
            } else {
                Log.warn(String.format("The product with name: %s is absent into cart. Please check your Map.",
                        itemNameFromMap));
            }
        }
    }

    public void deleteAllProducts() {
        List<String> itemNames = getAllProductNames();
        for (String name : itemNames) {
            cartPage.clickRemoveItemFromCart(name);
        }
    }

    public void deleteProduct(String productName) {
        cartPage.clickRemoveItemFromCart(productName);
    }

    public int getNumberOfProducts() {
        return cartPage.getNumberOfCartItems();
    }

    public int getTotalQuantityOfProducts() {
        List<String> itemNames = getAllProductNames();
        int totalQuantity = 0;
        for (String name : itemNames) {
            totalQuantity += cartPage.getItemQuantityValue(name);
        }
        return totalQuantity;
    }

    public List<String> getAllProductNames() {
        List<String> itemNames = cartPage.getAllItemsNames();
        return itemNames;
    }

    public String getProductPrice(String productName) {
        return cartPage.getItemUnitPrice(productName);
    }

    public int getProductQuantity(String productName) {
        return cartPage.getItemQuantityValue(productName);
    }
}
