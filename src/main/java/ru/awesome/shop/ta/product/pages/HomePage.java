package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class HomePage extends AbstractPage {
    private final static TextField searchField = new TextField(By.xpath("//input[@name='search']"));
    private final static Button searchButton = new Button(By.xpath("//button[@class='btn btn-default btn-lg']"));

    public HomePage(WebDriver driver) {
        super(driver);
        if (!"Your Store".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Home page");
        }
    }

    public HomePage typeProductNameToSearchField(String productName) {
        searchField.clear();
        searchField.type(productName);
        return this;
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
