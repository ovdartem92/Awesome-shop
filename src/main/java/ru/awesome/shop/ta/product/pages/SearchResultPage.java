package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Checkbox;
import ru.awesome.shop.ta.framework.ui.components.DropDownList;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.ArrayList;
import java.util.List;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;

public class SearchResultPage extends BasePage {
    private static final String SEARCH_RESULT_PAGE_URL = "index.php?route=product/search";

    public SearchResultPage open() {
        Browser.getInstance().navigate(BASE_URL.concat(SEARCH_RESULT_PAGE_URL));
        return this;
    }

    public SearchResultPage clickSearchButtonOnSearchResultPage() {
        By searchButtonLocator = By.xpath("//input[@id='button-search']");
        Button searchButton = new Button(searchButtonLocator);
        searchButton.click();
        return this;
    }

    public SearchResultPage setDescriptionCheckbox(boolean shouldBeChecked) {
        By descriptionCheckboxLocator = By.xpath("//input[@name='description']");
        Checkbox descriptionCheckbox = new Checkbox(descriptionCheckboxLocator);
        descriptionCheckbox.setSelected(shouldBeChecked);
        return this;
    }

    public SearchResultPage selectCategory(String option) {
        By categoryDropdownLocator = By.xpath("//select[@name='category_id']");
        DropDownList dropDownList = new DropDownList(categoryDropdownLocator);
        dropDownList.select(option);
        return this;
    }

    public String getIncorrectSearchCriteriaMessage() {
        By searchResultMessageLocator = By.xpath("//*[@id='content']/p[2]");
        Label label = new Label(searchResultMessageLocator);
        return label.getText();
    }

    public List<SearchResultFragment> getAllSearchResultsList() {
        By searchResultMessageLocator = By.xpath("//div[contains(@class,'product-layout')]");
        waitForAllElementsPresenceLocated(searchResultMessageLocator);
        List<SearchResultFragment> searchResultPageList = new ArrayList<>();
        List<WebElement> elements = Browser.getInstance().getWrappedDriver().findElements(searchResultMessageLocator);
        for (WebElement element : elements) {
            searchResultPageList.add(new SearchResultFragment(element));
        }
        return searchResultPageList;
    }
}
