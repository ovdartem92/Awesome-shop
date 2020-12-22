package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class LogoutPage extends BasePage {
    private static final String LOGOUT_PAGE_URL = "index.php?route=account/logout";

    public String getBreadcrumbLogoutText() {
        By breadcrumbLogoutLocator = By.xpath("//a[text()='Logout']");
        Link breadcrumbLogout = new Link(breadcrumbLogoutLocator);
        return breadcrumbLogout.getText();
    }

    public LogoutPage open() {
        Browser.getInstance().navigate(BASE_URL.concat(LOGOUT_PAGE_URL));
        return this;
    }
}

