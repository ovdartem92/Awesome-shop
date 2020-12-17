package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.login.LoginPage;
import ru.awesome.shop.ta.product.pages.login.LogoutPage;

public abstract class BasePage {
    private static final By MY_ACCOUNT_LINK_LOCATOR = By.xpath("//a[@title='My Account']");
    private static final By LOGIN_LINK_LOCATOR = By.xpath("//ul[contains(@class,'menu-right')]//a[text()='Login']");
    private static final By LOGOUT_LINK_LOCATOR = By.xpath("//ul[contains(@class,'menu-right')]//a[text()='Logout']");

    public BasePage clickOnMyAccountLink() {
        new Link(MY_ACCOUNT_LINK_LOCATOR).click();
        return this;
    }

    public LoginPage clickOnLoginLink() {
        new Link(LOGIN_LINK_LOCATOR).click();
        return new LoginPage();
    }

    public LogoutPage clickOnLogoutLink() {
        new Link(LOGOUT_LINK_LOCATOR).click();
        return new LogoutPage();
    }
}
