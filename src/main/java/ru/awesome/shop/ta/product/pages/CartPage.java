package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.framework.ui.components.TextField;

import java.util.List;

public class CartPage extends AbstractPage {
    private static final String FIRST = "1";
    private static final String PRODUCT_TBODY_TR_PATH = "//div[@class='table-responsive']//tbody//tr";
    private static final String LINK_PATH = "//a[text()]";
    private static final String QUANTITY_FIELD_PATH = "//input[contains(@name, 'quantity')]";
    private static final String REMOVE_PRODUCT_BUTTON_PATH = "//button[@data-original-title='Remove']";
    private static final String UPDATE_PRODUCT_BUTTON_PATH = "//button[@data-original-title='Update']";
    private static final String UNIT_PRICE_PATH = "//td[5]";

    private static final Link productLink = new Link(By
            .xpath(String.format("%s[%s]%s", PRODUCT_TBODY_TR_PATH, FIRST, LINK_PATH)));
    private static final Label productUnitPrice = new Label(By
            .xpath(String.format("%s[%s]%s", PRODUCT_TBODY_TR_PATH, FIRST, UNIT_PRICE_PATH)));
    private static final Button updateProductButton = new Button(By
            .xpath(String.format("%s[%s]%s", PRODUCT_TBODY_TR_PATH, FIRST, UPDATE_PRODUCT_BUTTON_PATH)));
    private static final Button removeProductButton = new Button(By
            .xpath(String.format("%s[%s]%s", PRODUCT_TBODY_TR_PATH, FIRST, REMOVE_PRODUCT_BUTTON_PATH)));
    private static final TextField quantityField = new TextField(By
            .xpath(String.format("%s[%s]%s", PRODUCT_TBODY_TR_PATH, FIRST, QUANTITY_FIELD_PATH)));

    private static final Link continueShoppingLink = new Link(By.xpath("//a[contains(text(),'Continue Shopping')]"));
    private static final Label warningQuantity = new Label(By
            .xpath("//div[contains(text(),'Products marked with *** are not available in the desired quantity or not in stock!')]"));
    private static final Label emptyCartText = new Label(By
            .xpath("//div[@id='content']//*[contains(text(),'Your shopping cart is empty!')]"));
    private static final Link continueButton = new Link(By
            .xpath("//div[@class='pull-right']//a[contains(text(),'Continue')]"));
    private static final Link checkoutLink = new Link(By.xpath("//a[contains(text(),'Checkout')]"));

    public CartPage(WebDriver driver) {
        super(driver);
        if (!"Shopping Cart".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Cart page");
        }
    }

    public String getProductNameIntoCart() {
        return productLink.getText();
    }

    public String getProductUnitPriceIntoCart() {
        return productUnitPrice.getText();
    }

    public CartPage clickRemoveProductButton() {
        removeProductButton.click();
        return this;
    }

    public CartPage clickUpdateProductButton() {
        updateProductButton.click();
        return this;
    }

    public CartPage typeQuantity(String quantity) {
        quantityField.clear();
        quantityField.type(quantity);
        return this;
    }

    public HomePage clickContinueButton(){
        continueButton.click();
        return new HomePage(driver);
    }
//valid case
    public CheckoutPage clickCheckoutButtonNavigateCheckout(){
        checkoutLink.click();
        return new CheckoutPage(driver);
    }
//not so valid case
    public CartPage clickCheckOutButtonStayOnCart(){
        checkoutLink.click();
        return this;
    }

    public HomePage clickContinueShoppingButton() {
        continueShoppingLink.click();
        return new HomePage(driver);
    }

    public boolean isEmptyShoppingCartMessageDisplayed() {
        return emptyCartText.getText().equals("Your shopping cart is empty!");
    }

    public boolean isCartContainsMoreThanOneProduct() {
        List<WebElement> productLinks = driver.findElements(By
                .xpath(PRODUCT_TBODY_TR_PATH));
            return productLinks.size() > 1;
    }

    public boolean isQuantityWarningDisplayed() {
        return warningQuantity.getText()
                .contains("Products marked with *** are not available in the desired quantity or not in stock!");
    }
}
