package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class Header {
    private Link myAccountLink = new Link(By.xpath("//a[@title='My Account']"));
    private Link loginLink = new Link(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']"));
    private Link logoutLink = new Link(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']"
            + "//a[text()='Logout']"));

    public Header clickOnMyAccountLink() {
        myAccountLink.click();
        return this;
    }

    public LoginPage clickOnLoginLink() {
        loginLink.click();
        return new LoginPage();
    }

    public LogoutPage clickOnLogoutLink() {
        logoutLink.click();
        return new LogoutPage();
    }
}
