package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;

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
}
