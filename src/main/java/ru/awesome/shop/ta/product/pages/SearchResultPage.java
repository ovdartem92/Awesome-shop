package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Checkbox;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.ArrayList;
import java.util.List;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;

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

    public List<SearchResultFragment> getAllSearchResults() {
        By searchResultMessageLocator = By.xpath("//div[contains(@class,'product-layout')]");
        waitForAllElementsPresenceLocated(searchResultMessageLocator);
        List<SearchResultFragment> searchResultPageList = new ArrayList<>();
        List<WebElement> elements = Browser.getInstance().getWrappedDriver().findElements(searchResultMessageLocator);
        for (WebElement element : elements) {
            searchResultPageList.add(new SearchResultFragment(element));
        }
        return searchResultPageList;
    }

    public boolean isSearchResultNameContainsOnSearchList(String productName) {
        return getAllSearchResults().stream()
                .anyMatch(products -> productName.equals(products.getName()));
    }

    public String getNameSearchProductByIndex(int expectedIndex) {
        return getAllSearchResults().get(expectedIndex).getName();
    }

    public int getTotalNumberOfSearchResult() {
        return getAllSearchResults().size();
    }
}
