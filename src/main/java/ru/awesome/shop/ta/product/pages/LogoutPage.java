package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class LogoutPage extends BasePage {

    public String getBreadcrumbLogoutText() {
        By breadcrumbLogoutLocator = By.xpath("//a[text()='Logout']");
        Link breadcrumbLogout = new Link(breadcrumbLogoutLocator);
        return breadcrumbLogout.getText();
    }
}
