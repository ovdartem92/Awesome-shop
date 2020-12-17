package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.WebElement;

public class SearchResultFragment {
    private WebElement searchResultElement;

    public SearchResultFragment(WebElement searchResultElement) {
        this.searchResultElement = searchResultElement;
    }

    public String getName() {
        return searchResultElement.getText().split("\n")[0];
    }

    public String getDescription() {
        return searchResultElement.getText();
    }

    public String getPrice() {
        return searchResultElement.getText();
    }
}
