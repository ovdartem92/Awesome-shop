package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForPageElementVisibilityLocated;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "index.php?route=common/home";

    public HomePage open() {
        Browser.getInstance().navigate(BASE_URL.concat(HOME_PAGE_URL));
        return this;
    }

    public void clickAddProductToCartButtonByName(String productName) {
        Button cartTotalButton = new Button(By.xpath("//div[@id='cart']"));
        String startTextFromCartTotalButton = cartTotalButton.getText();
        String[] arrayButtonInfo = startTextFromCartTotalButton.split(" ");
        int startQuantity = Integer.parseInt(arrayButtonInfo[0]);
        String endQuantity = Integer.toString(startQuantity + 1);
        String expectTextFromCartTotalButton = String
                .format("//span[@id='cart-total'][contains(text(), '%s item(s)')]", endQuantity);
        By addToCartButtonLocator = By
                .xpath(String.format("//div[@class='product-thumb transition']//a[text()='%s']/ancestor::" +
                        "div[@class='product-thumb transition']//button[contains(@onclick,'cart.add')]", productName));
        Button addToCartButton = new Button(addToCartButtonLocator);
        addToCartButton.click();
        waitForPageElementVisibilityLocated(By.xpath(expectTextFromCartTotalButton), 3);
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

