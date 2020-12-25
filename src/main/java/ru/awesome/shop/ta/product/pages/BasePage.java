package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.popups.AccountPopUp;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public abstract class BasePage {
    protected static final String BASE_URL = "https://awesome-shop.01sh.ru/";

    public AccountPopUp clickMyAccountLink() {
        By myAccountLinkLocator = By.xpath("//a[@title='My Account']");
        Link myAccountLink = new Link(myAccountLinkLocator);
        myAccountLink.click();
        return new AccountPopUp();
    }

    public BasePage typeSearchQuery(String query) {
        By searchTextInputLocator = By.xpath("//*[@id='search']//input");
        TextField textField = new TextField(searchTextInputLocator);
        textField.clear();
        textField.type(query);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        By searchButtonLocator = By.xpath("//*[@id='search']//button");
        Button searchButton = new Button(searchButtonLocator);
        searchButton.click();
        return new SearchResultPage();
    }

    public CartTotalPopup clickCartTotalButton() {
        By cartTotalButtonLocator = By.xpath("//div[@id='cart']//button//i[@class='fa fa-shopping-cart']");
        Button cartTotalButton = new Button(cartTotalButtonLocator);
        cartTotalButton.click();
        return new CartTotalPopup();
    }

    public String getPageTitle() {
        return Browser.getInstance().getPageTitle();
    }
}

