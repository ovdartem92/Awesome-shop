package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.DropDownList;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class HomePage extends AbstractPage {
    //общие поля хедер + поиск панель
    private final Button cartButton = new Button(By.xpath("//span[@id='cart-total']"));
    private final Button viewCartButton = new Button(By.xpath("//*[contains(text(),'View Cart')]"));
    private final TextField searchField = new TextField(By.xpath("//input[@name='search']"));
    private final Button searchButton = new Button(By.xpath("//button[@class='btn btn-default btn-lg']"));
    //сделать через дропдаун?
    private final Label dropDownCartList = new Label(By
            .xpath("//p[contains(text(), 'Your shopping cart is empty!')]"));

    public HomePage(WebDriver driver) {
        super(driver);
        if (!"Your Store".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Home page");
        }
    }
    //общее
    public HomePage clickCartButton() {
        cartButton.click();
        return this;
    }
    //общее
    public CartPage clickViewCartButton() {
        viewCartButton.click();
        return new CartPage(driver);
    }
    //общее
    public HomePage clearAndTypeProductNameToSearchField(String productName) {
        searchField.clear();
        searchField.type(productName);
        return this;
    }
    //общее
    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }
    //общее
    public boolean isCartDropDownEmptyMessageDisplayed(){
        return dropDownCartList.getText().contains("Your shopping cart is empty!");
    }

    //общее
    public String getPageTitle (){
        return driver.getTitle();
    }

}
