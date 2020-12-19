package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class LogoutPage extends BasePage {

    public LogoutPage open(){
        Browser.getInstance().navigate("https://awesome-shop.01sh.ru/index.php?route=account/logout");
        return new LogoutPage();
    }

    public String getBreadcrumbLogoutText() {
        By breadcrumbLogoutLocator = By.xpath("//a[text()='Logout']");
        Link breadcrumbLogout = new Link(breadcrumbLogoutLocator);
        return breadcrumbLogout.getText();
    }
}
