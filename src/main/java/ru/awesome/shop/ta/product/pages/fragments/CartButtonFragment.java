package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.product.pages.CartPage;

public class CartButtonFragment {
    private static final By cartButtonLocator = By.xpath("//span[@id='cart-total']");
    private static final Button cartButton = new Button(cartButtonLocator);

    public CartButtonFragment clickCartButton() {
        cartButton.click();
        return this;
    }

    public CartButtonFragment clickCartButtonContainsProducts() {
        By cartContainsProductsButtonLocator = By.xpath("//div[@id='cart']");
        Button cartContainsProductsButton = new Button(cartContainsProductsButtonLocator);
        cartContainsProductsButton.click();
        return this;
    }

    public CartPage clickViewCartButton() {
        By viewCartButtonLocator = By.xpath("//*[contains(text(),'View Cart')]");
        Button viewCartButton = new Button(viewCartButtonLocator);
        viewCartButton.click();
        return new CartPage();
    }

    public String getCartDropDownEmptyMessage() {
        By cartEmptyMessageLabelLocator = By.xpath("//p[contains(text(), 'Your shopping cart is empty!')]");
        Label cartEmptyMessageLabel = new Label(cartEmptyMessageLabelLocator);
        return cartEmptyMessageLabel.getText();
    }
}
