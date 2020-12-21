package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.WebElement;

public class SearchResultFragment {
    private final WebElement searchResultElement;

    public SearchResultFragment(WebElement searchResultElement) {
        this.searchResultElement = searchResultElement;
    }

    public String getName() {
        return searchResultElement.getText().split("\n")[0];
    }
}
