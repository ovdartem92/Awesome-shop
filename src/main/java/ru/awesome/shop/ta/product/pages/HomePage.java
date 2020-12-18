package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.product.pages.fragments.HomePageFragment;

import java.util.ArrayList;
import java.util.List;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;

public class HomePage {

    public List<HomePageFragment> getProductsList() {
        By productLocator = By.xpath("//div[@class='product-thumb transition']");
        waitForAllElementsPresenceLocated(productLocator);
        List<WebElement> productsList = Browser.getInstance().getWrappedDriver().findElements(productLocator);
        List<HomePageFragment> homeFragments = new ArrayList<>();
        for (WebElement element : productsList) {
            homeFragments.add(new HomePageFragment(element));
        }
        return homeFragments;
    }
}

