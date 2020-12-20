package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

abstract class BasePage {
    protected final String BASE_URL = "https://awesome-shop.01sh.ru/";

    public CartTotalPopup clickCartTotalButton() {
        By cartTotalButtonLocator = By.xpath("//div[@class='col-sm-3']//button//i[@class='fa fa-shopping-cart']");
        Button cartTotalButton = new Button(cartTotalButtonLocator);
        cartTotalButton.click();
        return new CartTotalPopup();
    }
}
