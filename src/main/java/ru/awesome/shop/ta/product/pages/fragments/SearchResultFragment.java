package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultFragment {
    private WebElement element;

    public SearchResultFragment(WebElement element) {
        this.element = element;
    }

    public SearchResultFragment clickAddToCartButton() {
        WebElement addToCartButton = element.findElement(By.xpath(".//button[contains(@onclick,'cart.add')]"));
//        By addToCartButtonLocator = By.xpath("//button[contains(@onclick,'cart.add')]");
//        Button addToCartButton = new Button(addToCartButtonLocator);
        addToCartButton.click();
        return this;
    }

    public String getProductNameFromArea() {
        WebElement productNameLink = element.findElement(By.xpath(".//h4//a"));
//        By productNameLinkLocator = By.xpath("//h4//a");
//        Link productNameLink = new Link(productNameLinkLocator);
        return productNameLink.getText();
    }

    public String getProductPriceFromArea() {
        WebElement productPriseField = element.findElement(By.xpath(".//p[@class='price']"));
//        By productPriceFieldLocator = By.xpath("//p[@class='price']");
//        Label productPriseField = new Label(productPriceFieldLocator);
        String[] array = productPriseField.getText().split("\n");
        return array[0];
    }
}
