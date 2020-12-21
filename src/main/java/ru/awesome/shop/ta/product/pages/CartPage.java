package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.fragments.CartItemFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;
import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForPageElementInvisibilityLocated;

public class CartPage extends BasePage {

    public List<CartItemFragment> getAllCartItems() {
        By cartItemLocator = By.xpath("//div[@class='table-responsive']//tbody//tr");
        waitForAllElementsPresenceLocated(cartItemLocator);
        List<WebElement> cartItemElements = Browser.getInstance().getWrappedDriver().findElements(cartItemLocator);
        List<CartItemFragment> cartItemFragments = new ArrayList<>();
        for (WebElement element : cartItemElements) {
            cartItemFragments.add(new CartItemFragment(element));
        }
        return cartItemFragments;
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

    public void clickRemoveItemFromCartByName(String productName) {
        By removeButtonLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::" +
                        "tr//button[contains(@onclick,'cart.remove')]", productName));
        Button removeButton = new Button(removeButtonLocator);
        removeButton.click();
        waitForPageElementInvisibilityLocated(removeButtonLocator, 3);
    }

    public String getItemNameByName(String productName) {
        By nameLabelLocator = By.xpath(String.format("//div[@class='table-responsive']//a[text()='%s']", productName));
        Label itemNameLabel = new Label(nameLabelLocator);
        return itemNameLabel.getText();
    }

    public String getItemUnitPriceByName(String productName) {
        By unitPriceLabelLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::tr//td[5]", productName));
        Label unitPriceLabel = new Label(unitPriceLabelLocator);
        return unitPriceLabel.getText();
    }

    public void clickUpdateItemButtonByName(String productName) {
        By updateItemButtonLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::tr//button[@data-original-title='Update']",
                productName));
        Button updateItemButton = new Button(updateItemButtonLocator);
        updateItemButton.click();
    }

    public void typeItemQuantityByName(String productName, int quantity) {
        Objects.requireNonNull(quantity, "QUANTITY cannot be null.");
        By quantityFieldLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::tr//input[contains(@name,'quantity')]",
                productName));
        TextField quantityField = new TextField(quantityFieldLocator);
        quantityField.clear();
        quantityField.type(String.valueOf(quantity));
    }

    public int getItemQuantityValueByName(String productName) {
        By quantityFieldLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::tr//input[contains(@name,'quantity')]",
                productName));
        TextField quantityField = new TextField(quantityFieldLocator);
        return Integer.parseInt(quantityField.getAttribute("value"));
    }

    public int getSizeOfCartItemsList() {
        By cartItemLocator = By.xpath("//div[@class='table-responsive']//tbody//tr");
        waitForAllElementsPresenceLocated(cartItemLocator);
        List<WebElement> cartItemElements = Browser.getInstance().getWrappedDriver().findElements(cartItemLocator);
        return cartItemElements.size();
    }
}
