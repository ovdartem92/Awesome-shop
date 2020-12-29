package ru.awesome.shop.ta.product.services;

import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.logging.Log;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

import java.util.List;
import java.util.Map;

public class CartService {
    private CartPage cartPage = new CartPage();
    private CartTotalPopup cartTotalPopup = new CartTotalPopup();

    public void updateProductQuantity(String productName, int quantity) {
        cartPage.typeItemQuantity(productName, quantity);
        cartPage.clickUpdateItemButton(productName);
    }

    public List<String> getAllProductNames() {
        List<String> itemNames = cartPage.getAllItemsNames();
        return itemNames;
    }

    public void updateProductsQuantity(Map<String, Integer> productNameToQuantityMapping) {
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

    public String getProductName(String productName) {
        return cartPage.getItemName(productName);
    }

    public String getProductPrice(String productName) {
        return cartPage.getItemUnitPrice(productName);
    }

    public int getProductQuantity(String productName) {
        return cartPage.getItemQuantityValue(productName);
    }

    public void clickCheckoutExpectingFailure() {
        cartPage.clickCheckoutButtonExpectingFailure();
    }

    public String getQuantityWarning() {
        return cartPage.getQuantityWarningMessage();
    }

    public String getEmptyCartMessage() {
        return cartPage.getEmptyShoppingCartMessage();
    }

    public String getEmptyCartMessageFromPopup() {
        cartPage.clickCartTotalButton();
        return cartTotalPopup.getEmptyCartMessage();
    }
}
