package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.awesome.shop.ta.framework.ui.components.Button;


public class SearchResultsPage extends AbstractPage {
    private static final String PRODUCT_THUMB_PATH = "//div[@class='product-thumb']";
    private static final String ADD_TO_CART_BUTTON_PATH = "//button[contains(@onclick,'cart.add')]";
    private final static Button addToCartButton = new Button(By
            .xpath(String.format("%s%s", PRODUCT_THUMB_PATH, ADD_TO_CART_BUTTON_PATH)));
    private final static Button cartButton = new Button(By.xpath("//span[@id='cart-total']"));
    private final static Button viewCartButton = new Button(By.xpath("//*[contains(text(),'View Cart')]"));

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        if (!driver.getTitle().contains("Search")) {
            throw new IllegalStateException("This is not the Search page");
        }
    }

    public SearchResultsPage clickAddToCart() {
        addToCartButton.click();
        return this;
    }

    public SearchResultsPage clickCartButton() {
        cartButton.click();
        return this;
    }

    public CartPage clickViewCartButton() {
        viewCartButton.click();
        return new CartPage(driver);
    }
}
