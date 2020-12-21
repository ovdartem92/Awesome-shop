package ru.awesome.shop.ta.product.pages.popups;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.LoginPage;
import ru.awesome.shop.ta.product.pages.LogoutPage;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;

public class AccountPopUp {

    public AccountRegistrationPage clickRegistrationLink() {
        By registrationLinkLocator = By.xpath("//a[text()='Register']");
        Link registrationLink = new Link(registrationLinkLocator);
        registrationLink.click();
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
