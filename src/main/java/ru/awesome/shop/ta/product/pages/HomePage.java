package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.product.pages.fragments.HomeProductFragment;

import java.util.ArrayList;
import java.util.List;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_PATH = "index.php?route=common/home";

    public List<HomeProductFragment> getAllProducts() {
        By productLocator = By.xpath("//div[@class='product-thumb transition']");
        waitForAllElementsPresenceLocated(productLocator);
        List<WebElement> productElements = Browser.getInstance().getWrappedDriver().findElements(productLocator);
        List<HomeProductFragment> homeProducts = new ArrayList<>();
        for (WebElement element : productElements) {
            homeProducts.add(new HomeProductFragment(element));
        }
        return homeProducts;
    }

    public HomePage open() {
        Browser.getInstance().navigate(BASE_URL + HOME_PAGE_PATH);
        return this;
    }
}

