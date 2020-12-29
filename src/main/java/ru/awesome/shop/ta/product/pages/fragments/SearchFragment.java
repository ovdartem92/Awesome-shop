package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.SearchResultPage;

public class SearchFragment {

    public SearchResultPage performSearchByPressingEnter(String searchCriteria) {
        String enter = "\n";
        typeSearchQuery(searchCriteria + enter);
        return new SearchResultPage();
    }

    public SearchFragment typeSearchQuery(String searchCriteria) {
        By searchTextInputLocator = By.xpath("//*[@id='search']//input");
        TextField textField = new TextField(searchTextInputLocator);
        textField.clear();
        textField.type(searchCriteria);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        By searchButtonLocator = By.xpath("//*[@id='search']//button");
        Button searchButton = new Button(searchButtonLocator);
        searchButton.click();
        return new SearchResultPage();
    }
}
