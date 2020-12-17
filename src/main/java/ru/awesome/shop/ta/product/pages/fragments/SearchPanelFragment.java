package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class SearchPanelFragment {

    public SearchPanelFragment typeProductName(String productName) {
        By searchFieldLocator = By.xpath("//input[@name='search']");
        TextField searchField = new TextField(searchFieldLocator);
        searchField.clear();
        searchField.type(productName);
        return this;
    }

    public SearchResultsPage clickSearchButton() {
        By searchButtonLocator = By.xpath("//button[@class='btn btn-default btn-lg']");
        Button searchButton = new Button(searchButtonLocator);
        searchButton.click();
        return new SearchResultsPage();
    }
}
