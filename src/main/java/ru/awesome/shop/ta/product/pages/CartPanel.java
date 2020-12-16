package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;

public class CartPanel extends AbstractPage{
    private final Button cartButton = new Button(By.xpath("//div[@id='cart']//span[@id='cart-total']"));
    private final Button cartButtonContainsProducts = new Button(By.xpath("//div[@id='cart']"));
    private final Button viewCartButton = new Button(By.xpath("//*[contains(text(),'View Cart')]"));
    private final Label cartInfo = new Label(By.xpath("//p[contains(text(), 'Your shopping cart is empty!')]"));

    public CartPanel(WebDriver driver) {
        super(driver);
    }

    //общее корзина
    public void clickCartButton() {
        cartButton.click();
    }

    public void clickCartButtonContainsProducts() {
        cartButtonContainsProducts.click();
    }

    //общее корзина
    public CartPage clickViewCartButton() {
        viewCartButton.click();
        return new CartPage(driver);
    }

    //общее корзина
    public boolean isCartDropDownEmptyMessageDisplayed() {
        return cartInfo.getText().contains("Your shopping cart is empty!");
    }
}
