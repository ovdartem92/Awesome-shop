package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartItemFragment {
    private WebElement cartItemElement;

    public CartItemFragment(WebElement cartItemElement) {
        this.cartItemElement = cartItemElement;
    }

    public String getCartItemName() {
        WebElement productNameLink = cartItemElement.findElement(By.xpath(".//a[text()]"));
        return productNameLink.getText();
    }

    public String getCartItemUnitPrice() {
        WebElement productUnitPriceLabel = cartItemElement.findElement(By.xpath(".//td[5]"));
        return productUnitPriceLabel.getText();
    }

    public void clickCartItemRemoveButton() {
        WebElement removeProductButton = cartItemElement
                .findElement(By.xpath(".//button[@data-original-title='Remove']"));
        removeProductButton.click();
    }

    public void clickCartItemUpdateButton() {
        WebElement updateProductButton = cartItemElement
                .findElement(By.xpath(".//button[@data-original-title='Update']"));
        updateProductButton.click();
    }

    public CartItemFragment typeCartItemQuantity(int quantity) {
        WebElement quantityField = cartItemElement
                .findElement(By.xpath(".//input[contains(@name,'quantity')]"));
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
        return this;
    }

    public int getCartItemQuantityValue() {
        WebElement quantityField = cartItemElement
                .findElement(By.xpath(".//input[contains(@name,'quantity')]"));
        return Integer.parseInt(quantityField.getAttribute("value"));
    }
}
