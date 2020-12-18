package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageFragment {
    private WebElement productElement;

    public HomePageFragment(WebElement productElement) {
        this.productElement = productElement;
    }

    public HomePageFragment clickAddToCartButton() {
        WebElement addToCartButton = productElement
                .findElement(By.xpath(".//button[contains(@onclick,'cart.add')]"));
        addToCartButton.click();
        return this;
    }

    public String getProductNameFromArea() {
        WebElement productNameLink = productElement.findElement(By.xpath(".//h4//a"));
        return productNameLink.getText();
    }

    public String getProductPriceFromArea() {
        WebElement productPriseField = productElement.findElement(By.xpath(".//p[@class='price']"));
        String[] array = productPriseField.getText().split("\n");
        return array[0];
    }
}
