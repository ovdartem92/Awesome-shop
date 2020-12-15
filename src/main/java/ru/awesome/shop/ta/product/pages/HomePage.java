package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class HomePage extends AbstractPage {
    //общие поля корзина
    private final Button cartButton = new Button(By.xpath("//div[@id='cart']//span[@id='cart-total']"));
    //private final Button cartButton = new Button(By.xpath("//div[@id='cart']"));
    private final Button viewCartButton = new Button(By.xpath("//*[contains(text(),'View Cart')]"));
    private final Label cartInfo = new Label(By.xpath("//p[contains(text(), 'Your shopping cart is empty!')]"));
    //общие поля поиск панель
    private final TextField searchField = new TextField(By.xpath("//input[@name='search']"));
    private final Button searchButton = new Button(By.xpath("//button[@class='btn btn-default btn-lg']"));

    public HomePage(WebDriver driver) {
        super(driver);
        if (!"Your Store".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Home page");
        }
    }

    //общее корзина
    public HomePage clickCartButton() {
        cartButton.click();
        return this;
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

    //общее панель поиска
    public HomePage clearAndTypeProductNameToSearchField(String productName) {
        searchField.clear();
        searchField.type(productName);
        return this;
    }

    //общее панель поиска
    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    //общее для всех
    public String getPageTitle() {
        return driver.getTitle();
    }
}
