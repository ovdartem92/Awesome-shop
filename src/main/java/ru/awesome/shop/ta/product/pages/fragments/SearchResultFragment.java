package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultFragment {
    private WebElement searchResultFragmentElement;

    public SearchResultFragment(WebElement searchResultFragmentElement) {
        this.searchResultFragmentElement = searchResultFragmentElement;
    }

    public SearchResultFragment clickAddToCartButton() {
        WebElement addToCartButton = searchResultFragmentElement
                .findElement(By.xpath(".//button[contains(@onclick,'cart.add')]"));
        addToCartButton.click();
        return this;
    }

    public String getProductNameFromArea() {
        WebElement productNameLink = searchResultFragmentElement.findElement(By.xpath(".//h4//a"));
        return productNameLink.getText();
    }

    public String getProductPriceFromArea() {
        WebElement productPriseField = searchResultFragmentElement.findElement(By.xpath(".//p[@class='price']"));
        String[] array = productPriseField.getText().split("\n");
        return array[0];
    }
}
