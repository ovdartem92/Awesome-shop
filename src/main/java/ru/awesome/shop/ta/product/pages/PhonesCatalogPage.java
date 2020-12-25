package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;

public class PhonesCatalogPage extends BasePage {
    private static final String PHONES_CATALOG_PAGE_URL = "index.php?route=product/category&path=24";

    public PhonesCatalogPage open() {
        Browser.getInstance().navigate(BASE_URL.concat(PHONES_CATALOG_PAGE_URL));
        return this;
    }

    public void clickAddPhoneToCartButton(String phoneName) {
        By addToCartButtonLocator = By
                .xpath(String.format("//div[@class='product-thumb']//a[text()='%s']/ancestor" +
                        "::div[@class='product-thumb']//button[contains(@onclick,'cart.add')]", phoneName));
        Button addToCartButton = new Button(addToCartButtonLocator);
        addToCartButton.click();
    }
}
