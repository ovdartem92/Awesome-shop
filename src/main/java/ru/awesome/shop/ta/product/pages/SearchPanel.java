package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class SearchPanel extends AbstractPage{
    private final static TextField searchField = new TextField(By.xpath("//input[@name='search']"));
    private final static Button searchButton = new Button(By.xpath("//button[@class='btn btn-default btn-lg']"));

    public SearchPanel(WebDriver driver) {
        super(driver);
    }

    public void clearAndTypeProductNameToSearchField(String productName) {
        searchField.clear();
        searchField.type(productName);
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
