package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeItemFragment {
    private WebElement homeItemFragmentElement;

    public HomeItemFragment(WebElement homeItemFragmentElement) {
        this.homeItemFragmentElement = homeItemFragmentElement;
    }

    public HomeItemFragment clickAddToCartButton() {
        WebElement addToCartButton = homeItemFragmentElement
                .findElement(By.xpath(".//button[contains(@onclick,'cart.add')]"));
        addToCartButton.click();
        return this;
    }

    public String getProductName() {
        WebElement productNameLink = homeItemFragmentElement.findElement(By.xpath(".//h4//a"));
        return productNameLink.getText();
    }

    public String getProductPrice() {
        WebElement productPriseField = homeItemFragmentElement.findElement(By.xpath(".//p[@class='price']"));
        String[] array = productPriseField.getText().split("\n");
        return array[0];
    }
}
