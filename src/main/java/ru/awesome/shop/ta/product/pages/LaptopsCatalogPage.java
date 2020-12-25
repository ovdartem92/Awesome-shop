package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class LaptopsCatalogPage extends BasePage {
    private static final String LAPTOPS_CATALOG_PAGE_URL = "index.php?route=product/category&path=18";

    public LaptopsCatalogPage open() {
        Browser.getInstance().navigate(BASE_URL.concat(LAPTOPS_CATALOG_PAGE_URL));
        return this;
    }

    public void clickAddLaptopToCartButton(String laptopName) {
        By addToCartButtonLocator = By
                .xpath(String.format("//div[@class='product-thumb']//a[text()='%s']/ancestor" +
                        "::div[@class='product-thumb']//button[contains(@onclick,'cart.add')]", laptopName));
        Button addToCartButton = new Button(addToCartButtonLocator);
        addToCartButton.click();
    }

    public String getLaptopName(String laptopName) {
        By laptopNameLinkLocator = By
                .xpath(String.format("//div[@class='product-thumb']//a[text()='%s']", laptopName));
        Link laptopNameLink = new Link(laptopNameLinkLocator);
        return laptopNameLink.getText();
    }

    public String getLaptopPrice(String laptopPrice) {
        By laptopPriceLabelLocator = By
                .xpath(String.format("//div[@class='product-thumb']//a[text()='%s']/ancestor::" +
                        "div[@class='product-thumb']//p[@class='price']", laptopPrice));
        Label laptopPriceLabel = new Label(laptopPriceLabelLocator);
        String[] array = laptopPriceLabel.getText().split("\n");
        return array[0];
    }
}
