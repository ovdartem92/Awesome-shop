package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;

import static java.lang.String.format;

public class NavigatePanel {
    private final String accountLinkType = "//a[contains(text(), '%s')]";
    private final String currencyType = "//ul[@class='dropdown-menu']//button[@name='%s']";

    public String getCurrencySign() {
        By currencySignLocator = By.xpath("//button[contains(@class, 'dropdown-toggle')]/strong");
        Label currencySignLabel = new Label(currencySignLocator);
        return currencySignLabel.getText();
    }

    public NavigatePanel clickChangeCurrencyButton() {
        By changeCurrencyButtonLocator = By.xpath("//span[contains(text(), 'Currency')]/..");
        Button changeCurrencyButton = new Button(changeCurrencyButtonLocator);
        changeCurrencyButton.click();
        return this;
    }

    public NavigatePanel clickContactUs() {
        By contactUsLinkLocator = By.xpath("//i[contains(@class, 'fa-phone')]/..");
        Link contactUsLink = new Link(contactUsLinkLocator);
        contactUsLink.click();
        return this;
    }

    public NavigatePanel clickMyAccountLink() {
        By myAccountLocator = By.xpath("//span[contains(text(), 'My Account')]/..");
        Link myAccountLink = new Link(myAccountLocator);
        myAccountLink.click();
        return this;
    }

    public NavigatePanel clickWishListLink() {
        By wishListLinkLocator = By.xpath("//span[contains(text(), 'Wish List')]/..");
        Link wishListLink = new Link(wishListLinkLocator);
        wishListLink.click();
        return this;
    }

    public NavigatePanel clickShoppingCartLink() {
        By shoppingCartLinkLocator = By.xpath("//span[contains(text(), 'Shopping Cart')]/..");
        Link shoppingCartLink = new Link(shoppingCartLinkLocator);
        shoppingCartLink.click();
        return this;
    }

    public NavigatePanel clickCheckoutLink() {
        By checkoutLinkLocator = By.xpath("//span[contains(text(), 'Checkout')]/..");
        Link checkoutLink = new Link(checkoutLinkLocator);
        checkoutLink.click();
        return this;
    }

    public AccountRegistrationPage clickRegistrationLink() {
        By checkoutLinkLocator = By.xpath(format(accountLinkType, "Register"));
        Link checkoutLink = new Link(checkoutLinkLocator);
        checkoutLink.click();
        return new AccountRegistrationPage();
    }
}
