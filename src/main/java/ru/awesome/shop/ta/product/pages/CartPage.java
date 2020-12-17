package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.product.pages.fragments.CartItemFragment;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    public List<CartItemFragment> getAllCartItemsList() {
        By lineOfTableLocator = By.xpath("//div[@class='table-responsive']//tbody//tr");
        List<WebElement> linesOfTable = Browser.getInstance().getWrappedDriver().findElements(lineOfTableLocator);
        List<CartItemFragment> cartItemFragmentList = new ArrayList<>();
        for (WebElement element : linesOfTable) {
            cartItemFragmentList.add(new CartItemFragment(element));
        }
        return cartItemFragmentList;
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

    public String getQuantityWarningMessage() {
        By warningQuantityLabelLocator = By.xpath("//div[contains(text(),'Products marked with ***')]");
        Label warningQuantityLabel = new Label(warningQuantityLabelLocator);
        return warningQuantityLabel.getText();
    }
}
