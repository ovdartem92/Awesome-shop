package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;

import static java.lang.String.format;

public class NavigatePanel {
    private final String accountLinkType = "//a[contains(text(), '%s')]";

    public NavigatePanel clickMyAccountLink() {
        By myAccountLocator = By.xpath("//span[contains(text(), 'My Account')]/..");
        Link myAccountLink = new Link(myAccountLocator);
        myAccountLink.click();
        return this;
    }

    public AccountRegistrationPage clickRegistrationLink() {
        By checkoutLinkLocator = By.xpath(format(accountLinkType, "Register"));
        Link checkoutLink = new Link(checkoutLinkLocator);
        checkoutLink.click();
        return new AccountRegistrationPage();
    }
}
