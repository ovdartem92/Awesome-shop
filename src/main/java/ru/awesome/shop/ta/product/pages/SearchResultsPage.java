package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.ArrayList;
import java.util.List;


public class SearchResultsPage {

    private static final By resultSearchProductLocator = By.xpath("//div[@class='product-thumb']");

    public List<SearchResultFragment> getSearchResultsList () {
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

    public String getProductNameFromArea() {
        By productNameLinkLocator = By.xpath("//h4//a");
        Link productNameLink = new Link(productNameLinkLocator);
        return productNameLink.getText();
    }

    public String getProductPriceFromArea() {
        By productPriceFieldLocator = By.xpath("//p[@class='price']");
        Label productPriseField = new Label(productPriceFieldLocator);
        String[] array = productPriseField.getText().split("\n");
        return array[0];
    }
}
