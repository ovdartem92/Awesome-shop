package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.product.pages.fragments.HomeItemFragment;

import java.util.ArrayList;
import java.util.List;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;

public class HomePage extends BasePage {

    public List<HomeItemFragment> getAllProducts() {
        By productLocator = By.xpath("//div[@class='product-thumb transition']");
        waitForAllElementsPresenceLocated(productLocator);
        List<WebElement> productElements = Browser.getInstance().getWrappedDriver().findElements(productLocator);
        List<HomeItemFragment> homeProducts = new ArrayList<>();
        for (WebElement element : productElements) {
            homeProducts.add(new HomeItemFragment(element));
        }
        return homeProducts;
    }
}

