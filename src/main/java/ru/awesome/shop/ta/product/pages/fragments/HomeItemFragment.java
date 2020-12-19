package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeItemFragment {
    private WebElement homeItemElement;

    public HomeItemFragment(WebElement homeItemElement) {
        this.homeItemElement = homeItemElement;
    }

    public HomeItemFragment clickAddToCartButton() {
        WebElement addToCartButton = homeItemElement.findElement(By.xpath(".//button[contains(@onclick,'cart.add')]"));
        addToCartButton.click();
        return this;
    }

    public String getProductName() {
        WebElement productNameLink = homeItemElement.findElement(By.xpath(".//h4//a"));
        return productNameLink.getText();
    }

    public String getProductPrice() {
        WebElement productPriseField = homeItemElement.findElement(By.xpath(".//p[@class='price']"));
        String[] array = productPriseField.getText().split("\n");
        return array[0];
    }
}
