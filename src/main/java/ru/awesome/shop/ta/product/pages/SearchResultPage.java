package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.logging.Log;
import ru.awesome.shop.ta.framework.ui.components.*;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.ArrayList;
import java.util.List;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;

public class SearchResultPage extends BasePage {
    private final By searchResultMessageLocator = By.xpath("//*[@id='content']/p[2]");

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

    public SearchResultPage setIMacCategory() {
        String iMacCategory = "      Mac";
        selectCategory(iMacCategory);
        return this;
    }

    public String getIncorrectSearchCriteriaMessage() {
        Label label = new Label(searchResultMessageLocator);
        return label.getText();
    }

    public List<SearchResultFragment> getAllSearchResults() {
        By searchResultProductsLocator = By.xpath("//div[contains(@class,'product-layout')]");
        waitForAllElementsPresenceLocated(searchResultProductsLocator);
        List<SearchResultFragment> searchResultPageList = new ArrayList<>();
        List<WebElement> elements = Browser.getInstance().getWrappedDriver().findElements(searchResultProductsLocator);
        for (WebElement element : elements) {
            searchResultPageList.add(new SearchResultFragment(element));
        }
        return searchResultPageList;
    }

    public boolean hasErrorMessage() {
        boolean isErrorFound = true;
        final int timeoutInSeconds = 2;
        try {
            CommonPageElement.waitForPageElementVisibilityLocated(searchResultMessageLocator, timeoutInSeconds);
        } catch (TimeoutException e) {
            Log.info("No error message found on search results page.");
            isErrorFound = false;
        }
        return isErrorFound;
    }
}
