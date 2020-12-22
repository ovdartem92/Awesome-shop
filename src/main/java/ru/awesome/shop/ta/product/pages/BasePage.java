package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.popups.AccountPopUp;

public abstract class BasePage {
    protected static final String BASE_URL = "https://awesome-shop.01sh.ru/";

    public AccountPopUp clickMyAccountLink() {
        By myAccountLinkLocator = By.xpath("//a[@title='My Account']");
        Link myAccountLink = new Link(myAccountLinkLocator);
        myAccountLink.click();
        return new AccountPopUp();
    }
}

