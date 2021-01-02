package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllPageElementsVisibilityLocated;
import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForPageElementInvisibilityLocated;

public class CartPage extends BasePage {
    private static final String CART_PAGE_URL = "index.php?route=checkout/cart";

    public CartPage open() {
        Browser.getInstance().navigate(BASE_URL.concat(CART_PAGE_URL));
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

    public String getQuantityWarningMessage() {
        By warningQuantityLabelLocator = By.xpath("//div[contains(text(),'Products marked with ***')]");
        Label warningQuantityLabel = new Label(warningQuantityLabelLocator);
        return warningQuantityLabel.getText();
    }

    public void clickRemoveItemFromCart(String productName) {
        int invisibilityTimeoutInSeconds = 3;
        By removeButtonLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::"
                        + "tr//button[contains(@onclick,'cart.remove')]", productName));
        Button removeButton = new Button(removeButtonLocator);
        removeButton.click();
        waitForPageElementInvisibilityLocated(removeButtonLocator, invisibilityTimeoutInSeconds);
    }

    public String getItemName(String productName) {
        By nameLabelLocator = By.xpath(String.format("//div[@class='table-responsive']//a[text()='%s']", productName));
        Label itemNameLabel = new Label(nameLabelLocator);
        return itemNameLabel.getText();
    }

    public String getItemUnitPrice(String productName) {
        By unitPriceLabelLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::tr//td[5]", productName));
        Label unitPriceLabel = new Label(unitPriceLabelLocator);
        return unitPriceLabel.getText();
    }

    public void clickUpdateItemButton(String productName) {
        By updateItemButtonLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::tr//button[@data-original-title='Update']",
                productName));
        Button updateItemButton = new Button(updateItemButtonLocator);
        updateItemButton.click();
    }

    public void typeItemQuantity(String productName, int quantity) {
        Objects.requireNonNull(quantity, "QUANTITY cannot be null.");
        By quantityFieldLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::tr//input[contains(@name,'quantity')]",
                productName));
        TextField quantityField = new TextField(quantityFieldLocator);
        quantityField.clear();
        quantityField.type(String.valueOf(quantity));
    }

    public int getItemQuantityValue(String productName) {
        By quantityFieldLocator = By.xpath(String.format(
                "//div[@class='table-responsive']//a[text()='%s']/ancestor::tr//input[contains(@name,'quantity')]",
                productName));
        TextField quantityField = new TextField(quantityFieldLocator);
        return Integer.parseInt(quantityField.getText());
    }

    public int getNumberOfCartItems() {
        return getAllItemsNames().size();
    }

    public List<String> getAllItemsNames() {
        int visibilityTimeoutInSeconds = 10;
        By itemNameLocator = By.xpath("//div[@class='table-responsive']//a[text()]");
        waitForAllPageElementsVisibilityLocated(itemNameLocator, visibilityTimeoutInSeconds);
        List<WebElement> itemNameElements = Browser.getInstance().getWrappedDriver().findElements(itemNameLocator);
        List<String> itemsNames = new ArrayList<>();
        for (WebElement element : itemNameElements) {
            String itemName = element.getText();
            itemsNames.add(itemName);
        }
        return itemsNames;
    }
}
