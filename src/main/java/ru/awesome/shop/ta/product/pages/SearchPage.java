package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Checkbox;
import ru.awesome.shop.ta.framework.ui.components.Label;

import static java.lang.String.format;

public class SearchPage {
    private static final By SEARCH_RESULT_MESSAGE_LOCATOR = By.xpath("//*[@id='content']/p[2]");
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//input[@id='button-search']");
    private static final By CATEGORY_DROPDOWN_LOCATOR = By.xpath("//select[@name='category_id']");
    private static final By DESCRIPTION_CHECKBOX_LOCATOR = By.xpath("//input[@name='description']");

    public SearchPage clickSearchButton() {
        new Button(SEARCH_BUTTON_LOCATOR).click();
        return this;
    }

    public SearchPage setDescriptionCheckbox(Boolean shouldBeChecked) {
        new Checkbox(DESCRIPTION_CHECKBOX_LOCATOR).setSelected(shouldBeChecked);
        return this;
    }

    public SearchPage selectCategory(int expectedIndex) {
        new Select(Browser
                .getInstance()
                .getWrappedDriver()
                .findElement(CATEGORY_DROPDOWN_LOCATOR))
                .selectByIndex(expectedIndex);
        return this;
    }

    public Boolean isSearchResultNameVisible(String expectedName) {
        return Browser
                .getInstance()
                .getWrappedDriver()
                .findElement(getSearchResultLocator(expectedName))
                .isDisplayed();
    }

    public String getNoSearchResultsMessage() {
        return new Label(SEARCH_RESULT_MESSAGE_LOCATOR).getText();
    }

    private By getSearchResultLocator(String name) {
        String productSearchType = "//a[contains(text(), '%s')]";
        String accountLinkLocator = format(productSearchType, name);
        return By.xpath(accountLinkLocator);
    }
}
