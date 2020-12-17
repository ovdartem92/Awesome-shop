package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.ArrayList;
import java.util.List;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;


public class SearchResultsPage {

    public List<SearchResultFragment> getSearchResultsList() {
        By resultSearchProductLocator = By.xpath("//div[@class='product-thumb']");
        waitForAllElementsPresenceLocated(resultSearchProductLocator);
        List<WebElement> resultSearchProductsList = Browser.getInstance().getWrappedDriver()
                .findElements(resultSearchProductLocator);
        List<SearchResultFragment> searchResultFragments = new ArrayList<>();
        for (WebElement element : resultSearchProductsList) {
            searchResultFragments.add(new SearchResultFragment(element));
        }
        return searchResultFragments;
    }

    public SearchResultsPage clickAddToCartButton() {
        By addToCartButtonLocator = By.xpath("//button[contains(@onclick,'cart.add')]");
        Button addToCartButton = new Button(addToCartButtonLocator);
        addToCartButton.click();
        return this;
    }
}
