package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class Header {
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//*[@id='search']//button");
    private static final By SEARCH_TEXT_INPUT_LOCATOR = By.xpath("//*[@id='search']//input");

    public Header typeTextToSearchInput(String txt) {
        TextField textField = new TextField(SEARCH_TEXT_INPUT_LOCATOR);
        textField.clear();
        textField.type(txt);
        return this;
    }

    public SearchPage clickSearchButton() {
        new Button(SEARCH_BUTTON_LOCATOR).click();
        return new SearchPage();
    }
}
