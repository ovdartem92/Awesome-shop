package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartItemFragment {
    private WebElement cartItemFragmentElement;

    public CartItemFragment(WebElement cartItemFragmentElement) {
        this.cartItemFragmentElement = cartItemFragmentElement;
    }

    public String getCartItemName() {
        WebElement productNameLink = cartItemFragmentElement.findElement(By.xpath(".//a[text()]"));
        return productNameLink.getText();
    }

    public String getCartItemUnitPrice() {
        WebElement productUnitPriceLabel = cartItemFragmentElement.findElement(By.xpath(".//td[5]"));
        return productUnitPriceLabel.getText();
    }

    public CartItemFragment clickCartItemRemoveButton() {
        WebElement removeProductButton = cartItemFragmentElement
                .findElement(By.xpath(".//button[@data-original-title='Remove']"));
        removeProductButton.click();
        return this;
    }

    public CartItemFragment clickCartItemUpdateButton() {
        WebElement updateProductButton = cartItemFragmentElement
                .findElement(By.xpath(".//button[@data-original-title='Update']"));
        updateProductButton.click();
        return this;
    }

    public CartItemFragment typeCartItemQuantity(int quantity) {
        WebElement quantityField = cartItemFragmentElement
                .findElement(By.xpath(".//input[contains(@name, 'quantity')]"));
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
        return this;
    }
}
