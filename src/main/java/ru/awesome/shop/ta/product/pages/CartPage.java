package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.framework.ui.components.TextField;

import java.util.List;

public class CartPage {
    private static final String lineOfProductsTablePath = "//div[@class='table-responsive']//tbody//tr";

    public String getProductNameIntoCart(int numberOfProductInCartList) {
        By productNameLinkLocator = By
                .xpath(lineOfProductsTablePath + "[" + numberOfProductInCartList + "]" + "//a[text()]");
        Link productNameLink = new Link(productNameLinkLocator);
        return productNameLink.getText();
    }

    public String getProductUnitPriceIntoCart() {
        By productUnitPriceLabelLocator = By.xpath(lineOfProductsTablePath + "//td[5]");
        Label productUnitPriceLabel = new Label(productUnitPriceLabelLocator);
        return productUnitPriceLabel.getText();
    }

    public CartPage clickRemoveProductButton() {
        By removeProductButtonLocator = By.xpath(lineOfProductsTablePath + "//button[@data-original-title='Remove']");
        Button removeProductButton = new Button(removeProductButtonLocator);
        removeProductButton.click();
        return this;
    }

    public CartPage clickUpdateProductButton() {
        By updateProductButtonLocator = By.xpath(lineOfProductsTablePath + "//button[@data-original-title='Update']");
        Button updateProductButton = new Button(updateProductButtonLocator);
        updateProductButton.click();
        return this;
    }

    public CartPage typeQuantity(int quantity) {
        By quantityFieldLocator = By.xpath("//input[contains(@name, 'quantity')]");
        TextField quantityField = new TextField(quantityFieldLocator);
        quantityField.clear();
        quantityField.type(String.valueOf(quantity));
        return this;
    }

    public HomePage clickContinueButton() {
        By continueButtonLocator = By.xpath("//div[@class='pull-right']//a[contains(text(),'Continue')]");
        Button continueButton = new Button(continueButtonLocator);
        continueButton.click();
        return new HomePage();
    }

    public CheckoutPage clickCheckoutButton() {
        By checkoutButtonLocator = By.xpath("//a[contains(text(),'Checkout')]");
        Button checkoutButton = new Button(checkoutButtonLocator);
        checkoutButton.click();
        return new CheckoutPage();
    }

    public CartPage clickCheckoutButtonExpectingFailure() {
        By checkoutButtonLocator = By.xpath("//a[contains(text(),'Checkout')]");
        Button checkoutButton = new Button(checkoutButtonLocator);
        checkoutButton.click();
        return this;
    }

    public HomePage clickContinueShoppingButton() {
        By continueShoppingButtonLocator = By.xpath("//a[contains(text(),'Continue Shopping')]");
        Button continueShoppingButton = new Button(continueShoppingButtonLocator);
        continueShoppingButton.click();
        return new HomePage();
    }

    public String getEmptyShoppingCartMessage() {
        By emptyCartLabelLocator = By.xpath("//div[@id='content']//*[contains(text(),'Your shopping cart is empty!')]");
        Label emptyCartLabel = new Label(emptyCartLabelLocator);
        return emptyCartLabel.getText();
    }

    public int getProductListSize() {
        List<WebElement> productLinks = Browser.getInstance().getWrappedDriver().findElements(By
                .xpath(lineOfProductsTablePath));
        return productLinks.size();
    }

    public String getQuantityWarningMessage() {
        By warningQuantityLabelLocator = By.xpath("//div[contains(text(),'Products marked with ***')]");
        Label warningQuantityLabel = new Label(warningQuantityLabelLocator);
        return warningQuantityLabel.getText();
    }
}
