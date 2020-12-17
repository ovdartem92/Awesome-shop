package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.login.LoginPage;
import ru.awesome.shop.ta.product.pages.login.LogoutPage;

public abstract class BasePage {

    public BasePage clickOnMyAccountLink() {
        final By myAccountLinkLocator = By.xpath("//a[@title='My Account']");
        new Link(myAccountLinkLocator).click();
        return this;
    }

    public LoginPage clickOnLoginLink() {
        By loginLinkLocator = By.xpath("//ul[contains(@class,'menu-right')]//a[text()='Login']");
        new Link(loginLinkLocator).click();
        return new LoginPage();
    }

    public LogoutPage clickOnLogoutLink() {
        By logoutLinkLocator = By.xpath("//ul[contains(@class,'menu-right')]//a[text()='Logout']");
        new Link(logoutLinkLocator).click();
        return new LogoutPage();
    }
}
