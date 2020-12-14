package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class CartPage extends AbstractPage {
    private static final String PRODUCT_NAME_TR_PATH = "//table[@class='table table-bordered']//tr";
    private static final String LINK_PATH = "//a[text()]";
    private final static Link productLink = new Link(By.xpath(String.format("%s%s", PRODUCT_NAME_TR_PATH, LINK_PATH)));

    public CartPage(WebDriver driver) {
        super(driver);
        if (!"Shopping Cart".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Cart page");
        }
    }

    public String getNameOfFirstProductIntoCart() {
        return productLink.getText();
    }
}
