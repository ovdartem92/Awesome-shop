package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public abstract class BasePage {

    public BasePage typeSearchQuery(String query) {
        final By searchTextInputLocator = By.xpath("//*[@id='search']//input");
        TextField textField = new TextField(searchTextInputLocator);
        textField.clear();
        textField.type(query);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        final By searchButtonLocator = By.xpath("//*[@id='search']//button");
        Button searchButton = new Button(searchButtonLocator);
        searchButton.click();
        return new SearchResultPage();
    }
}
