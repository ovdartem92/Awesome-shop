package ru.awesome.shop.ta.product.pages.popups;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.LoginPage;
import ru.awesome.shop.ta.product.pages.LogoutPage;

public class AccountPopUp {

    public AccountRegistrationPage clickRegistrationLink() {
        By checkoutLinkLocator = By.xpath("//a[text()='Register']");
        Link checkoutLink = new Link(checkoutLinkLocator);
        checkoutLink.click();
        return new AccountRegistrationPage();
    }

    public LoginPage clickLoginLink() {
        By loginLinkLocator = By.xpath("//ul[contains(@class,'menu-right')]//a[text()='Login']");
        Link loginLink = new Link(loginLinkLocator);
        loginLink.click();
        return new LoginPage();
    }

    public LogoutPage clickLogoutLink() {
        By logoutLinkLocator = By.xpath("//ul[contains(@class,'menu-right')]//a[text()='Logout']");
        Link logoutLink = new Link(logoutLinkLocator);
        logoutLink.click();
        return new LogoutPage();
    }
}
