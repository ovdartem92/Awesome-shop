package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResultFragment {
    private final WebElement searchResultElement;

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
        Pattern p = Pattern.compile("(\\$\\d+.\\d+)\\w+");
        Matcher matcher = p.matcher(searchResultElement.getText());
        return matcher.find() ? matcher.group(0) : "";
    }
}
