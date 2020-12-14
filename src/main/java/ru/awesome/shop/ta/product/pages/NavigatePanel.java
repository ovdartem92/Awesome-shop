package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationScreen;

import static java.lang.String.format;

public class NavigatePanel {
    private final By currencySignBy = By.xpath("//button[contains(@class, 'dropdown-toggle')]/strong");
    private final By changeCurrencyButtonBy = By.xpath("//span[contains(text(), 'Currency')]/..");
    private final By contactUsBy = By.xpath("//i[contains(@class, 'fa-phone')]/..");
    private final By myAccountBy = By.xpath("//span[contains(text(), 'My Account')]/..");
    private final By wishListBy = By.xpath("//span[contains(text(), 'Wish List')]/..");
    private final By shoppingCartBy = By.xpath("//span[contains(text(), 'Shopping Cart')]/..");
    private final By checkoutBy = By.xpath("//span[contains(text(), 'Checkout')]/..");

    private final String accountLinkType = "//a[contains(text(), '%s')]";
    private final String currencyType = "//ul[@class='dropdown-menu']//button[@name='%s']";

    public String getCurrencySign() {
        Label currencySign = new Label(currencySignBy);
        return currencySign.getText();
    }

    public AccountRegistrationScreen openAccountLinkScreen(AccountLink link) {
        myAccountLinkClick();
        By registerBy = getAccountLinkLocator(link);
        Link register = new Link(registerBy);
        register.click();
        return new AccountRegistrationScreen();
    }

    public NavigatePanel changeCurrency(Currency currency) {
        changeCurrencyButtonClick();
        By currencySelectLocator = getCurrencyTypeLocator(currency);
        Button currencyButton = new Button(currencySelectLocator);
        currencyButton.click();
        return this;
    }

    public NavigatePanel changeCurrencyButtonClick() {
        Button changeCurrencyButton = new Button(changeCurrencyButtonBy);
        changeCurrencyButton.click();
        return this;
    }

    public NavigatePanel contactUsClick() {
        Link contactUs = new Link(contactUsBy);
        contactUs.click();
        return this;
    }

    public NavigatePanel myAccountLinkClick() {
        Link myAccount = new Link(myAccountBy);
        myAccount.click();
        return this;
    }

    public NavigatePanel wishListLinkClick() {
        Link wishList = new Link(wishListBy);
        wishList.click();
        return this;
    }

    public NavigatePanel shoppingCartLinkClick() {
        Link shoppingCart = new Link(shoppingCartBy);
        shoppingCart.click();
        return this;
    }

    public NavigatePanel checkoutLinkClick() {
        Link checkout = new Link(checkoutBy);
        checkout.click();
        return this;
    }

    private By getCurrencyTypeLocator(Currency currency) {
        String currencyTypeLocator = format(currencyType, currency.getName());
        return By.xpath(currencyTypeLocator);
    }

    private By getAccountLinkLocator(AccountLink link) {
        String accountLinkLocator = format(accountLinkType, link.getName());
        return By.xpath(accountLinkLocator);
    }

    public enum Currency {
        EUR("EUR"), GBP("GBP"), USD("USD");

        private String name;

        Currency(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum AccountLink {
        REGISTER("Register"), LOGIN("Login"), MY_ACCOUNT("My Account"),
        ORDER_HISTORY("Order History"), TRANSACTION("Transaction"),
        DOWNLOADS("Downloads"), LOGOUT("Logout");

        private String name;

        AccountLink(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
