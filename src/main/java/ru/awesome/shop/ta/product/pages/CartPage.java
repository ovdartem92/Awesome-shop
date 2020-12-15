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
    //общee
    private final Button cartButton = new Button(By.xpath("//span[@id='cart-total']"));

    private static final String FIRST = "1";
    private static final String PRODUCT_NAME_TR_PATH = "//table[@class='table table-bordered']//tbody//tr";

    //подумать над реализацией
    private static final String TABLE_TBODY_LINE_PATH = String.format("%s[%s]", PRODUCT_NAME_TR_PATH, FIRST);

    private static final String LINK_PATH = "//a[text()]";
    private static final String QUANTITY_FIELD_PATH = "//input[contains(@name, 'quantity')]";
    private static final String REMOVE_PRODUCT_BUTTON_PATH = "//button[@data-original-title='Remove']";
    private static final String UPDATE_PRODUCT_BUTTON_PATH = "//button[@data-original-title='Update']";
    private static final String UNIT_PRICE_PATH = "//td[5]";

    private static final Link continueShoppingLink = new Link(By.xpath("//a[contains(text(),'Continue Shopping')]"));

    private static final Label warningQuantity = new Label(By.xpath(
            "//div[contains(text(),'Products marked with *** are not available in the desired quantity or not in stock!')]"));

    private final static Link productLink = new Link(By.xpath(String.format("%s%s", PRODUCT_NAME_TR_PATH, LINK_PATH)));
    private final static Label productUnitPrice = new Label(By.xpath(String.format("%s%s", PRODUCT_NAME_TR_PATH, UNIT_PRICE_PATH)));
    private final static Button updateProductButton = new Button(By
            .xpath(String.format("%s%s", PRODUCT_NAME_TR_PATH, UPDATE_PRODUCT_BUTTON_PATH)));
    private final static Button removeProductButton = new Button(By
            .xpath(String.format("%s%s", PRODUCT_NAME_TR_PATH, REMOVE_PRODUCT_BUTTON_PATH)));
    private final static TextField quantityField = new TextField(By
            .xpath(String.format("%s%s", PRODUCT_NAME_TR_PATH, QUANTITY_FIELD_PATH)));
    private final static Label emptyCartText = new Label(By
            .xpath("//div[@id='content']//*[contains(text(),'Your shopping cart is empty!')]"));


    private final static Link continueButton = new Link(By.xpath("//div[@class='pull-right']//a[contains(text(),'Continue')]"));

    private final static Link checkoutLink = new Link(By.xpath("//a[contains(text(),'Checkout')]"));


    public CartPage(WebDriver driver) {
        super(driver);
        if (!"Shopping Cart".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Cart page");
        }
    }

    public String getNameOfFirstProductIntoCart() {
        return productLink.getText();
    }

    public String getQuantityFromCartButton(){
        String [] array = cartButton.getText().split(" ");
        return array[0];
    }

    public String getUnitPriceOfFirstProductIntoCart() {
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

    public CheckoutPage clickCheckout1Button(){
        checkoutLink.click();
        return new CheckoutPage(driver);
    }

    public CartPage clickCheckOutLink(){
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
                .xpath(String.format("%s%s", PRODUCT_NAME_TR_PATH, LINK_PATH)));
            return productLinks.size() > 1;
    }

    public boolean isQuantityWarningDisplayed() {
        return warningQuantity.getText()
                .contains("Products marked with *** are not available in the desired quantity or not in stock!");
    }
}
