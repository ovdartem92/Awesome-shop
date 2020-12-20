package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.ui.components.Button;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.waitForPageElementVisibilityLocated;


public class HomeProductFragment {
    private WebElement homeItemElement;

    public HomeProductFragment(WebElement homeItemElement) {
        this.homeItemElement = homeItemElement;
    }

    public HomeProductFragment clickAddToCartButton() {
        Button cartTotalButton = new Button(By.xpath("//div[@id='cart']"));
        String startTextFromCartTotalButton = cartTotalButton.getText();
        String[] arrayButtonInfo = startTextFromCartTotalButton.split(" ");
        int startQuantity = Integer.parseInt(arrayButtonInfo[0]);
        String endQuantity = Integer.toString(startQuantity + 1);
        String expectTextFromCartTotalButton = String
                .format("//span[@id='cart-total'][contains(text(), '%s item(s)')]", endQuantity);
        WebElement addToCartButton = homeItemElement.findElement(By.xpath(".//button[contains(@onclick,'cart.add')]"));
        addToCartButton.click();
        waitForPageElementVisibilityLocated(By.xpath(expectTextFromCartTotalButton), 3);
        return this;
    }

    public String getProductName() {
        WebElement productNameLink = homeItemElement.findElement(By.xpath(".//h4//a"));
        return productNameLink.getText();
    }

    public String getProductPrice() {
        WebElement productPriseField = homeItemElement.findElement(By.xpath(".//p[@class='price']"));
        String[] array = productPriseField.getText().split("\n");
        return array[0];
    }
}
