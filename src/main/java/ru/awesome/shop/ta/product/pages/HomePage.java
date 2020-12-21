package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.fragments.HomeProductFragment;

import java.util.ArrayList;
import java.util.List;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "index.php?route=common/home";

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
        Browser.getInstance().navigate(BASE_URL.concat(HOME_PAGE_URL));
        return this;
    }

    public void clickAddProductToCartButtonByName(String productName) {
        By addToCartButtonLocator = By
                .xpath(String.format("//div[@class='product-thumb transition']//a[text()='%s']/ancestor::" +
                        "div[@class='product-thumb transition']//button[contains(@onclick,'cart.add')]", productName));
        Button addToCartButton = new Button(addToCartButtonLocator);
        addToCartButton.click();
    }

    public String getProductNameByName(String productName) {
        By productNameLinkLocator = By
                .xpath(String.format("//div[@class='product-thumb transition']//a[text()='%s']", productName));
        Link productNameLink = new Link(productNameLinkLocator);
        return productNameLink.getText();
    }

    public String getProductPriceByName(String productName) {
        By productPriceLabelLocator = By
                .xpath(String.format("//div[@class='product-thumb transition']//a[text()='%s']/ancestor::" +
                        "div[@class='product-thumb transition']//p[@class='price']", productName));
        Label productPriceLabel = new Label(productPriceLabelLocator);
        String[] array = productPriceLabel.getText().split("\n");
        return array[0];
    }
}

