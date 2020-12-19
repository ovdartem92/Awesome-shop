package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;

public class BasePage {

    public void open(){
    }

    public CartTotalPopup clickCartTotalButton() {
        By cartTotalButtonLocator = By.xpath("//div[@class='col-sm-3']//button//i[@class='fa fa-shopping-cart']");
        Button cartTotalButton = new Button(cartTotalButtonLocator);
        cartTotalButton.click();
        return new CartTotalPopup();
    }
}
