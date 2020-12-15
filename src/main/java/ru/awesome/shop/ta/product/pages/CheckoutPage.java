package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.WebDriver;

public class CheckoutPage extends AbstractPage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
        if (!"Checkout".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Checkout page");
        }
    }

    //общее
    public String getPageTitle() {
        return driver.getTitle();
    }
}
