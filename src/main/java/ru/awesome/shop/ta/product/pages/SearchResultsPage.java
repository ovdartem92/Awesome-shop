package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;


public class SearchResultsPage {
    public SearchResultsPage clickAddToCartButton() {
        By addToCartButtonLocator = By.xpath("//button[contains(@onclick,'cart.add')]");
        Button addToCartButton = new Button(addToCartButtonLocator);
        addToCartButton.click();
        return this;
    }

    public String getProductNameFromArea() {
        By productNameLinkLocator = By.xpath("//h4//a");
        Link productNameLink = new Link(productNameLinkLocator);
        return productNameLink.getText();
    }

    public String getProductPriceFromArea() {
        By productPriceFieldLocator = By.xpath("//p[@class='price']");
        Label productPriseField = new Label(productPriceFieldLocator);

        //куда-то вынести или че
        String[] array = productPriseField.getText().split("\n");
        return array[0];
    }
}
