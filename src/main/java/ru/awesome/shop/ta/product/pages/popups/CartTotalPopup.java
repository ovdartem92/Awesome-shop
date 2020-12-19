package ru.awesome.shop.ta.product.pages.popups;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.product.pages.CartPage;

public class CartTotalPopup {

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
