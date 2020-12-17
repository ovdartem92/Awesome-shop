package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Checkbox;
import ru.awesome.shop.ta.framework.ui.components.Label;

import static java.lang.String.format;

public class SearchResultPage extends BasePage {

    public SearchResultPage clickSearchButtonAfterSearch() {
        final By searchButtonLocator = By.xpath("//input[@id='button-search']");
        Button searchButton = new Button(searchButtonLocator);
        searchButton.click();
        return this;
    }

    public SearchResultPage setDescriptionCheckbox(Boolean shouldBeChecked) {
        final By descriptionCheckboxLocator = By.xpath("//input[@name='description']");
        Checkbox descriptionCheckbox = new Checkbox(descriptionCheckboxLocator);
        descriptionCheckbox.setSelected(shouldBeChecked);
        return this;
    }

    public SearchResultPage selectCategory(int expectedIndex) {
        final By categoryDropdownLocator = By.xpath("//select[@name='category_id']");
        Select select = new Select(Browser.getInstance().getWrappedDriver().findElement(categoryDropdownLocator));
        select.selectByIndex(expectedIndex);
        return this;
    }

    public String getNegativeSearchResultsMessage() {
        final By searchResultMessageLocator = By.xpath("//*[@id='content']/p[2]");
        Label label = new Label(searchResultMessageLocator);
        return label.getText();
    }

    public Boolean isSearchResultNameVisible(String expectedName) {
        return Browser
                .getInstance()
                .getWrappedDriver()
                .findElement(getSearchResultLocator(expectedName))
                .isDisplayed();
    }

    private By getSearchResultLocator(String name) {
        String productSearchType = "//a[contains(text(), '%s')]";
        String accountLinkLocator = format(productSearchType, name);
        return By.xpath(accountLinkLocator);
    }
}
