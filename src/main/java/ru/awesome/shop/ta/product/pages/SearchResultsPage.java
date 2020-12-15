package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.framework.ui.components.TextField;


public class SearchResultsPage extends AbstractPage {
    //общие поля корзина
    //private final Button cartButton = new Button(By.xpath("//div[@id='cart']//span[@id='cart-total']"));
    private final Button cartButton = new Button(By.xpath("//div[@id='cart']"));
    private final Button viewCartButton = new Button(By.xpath("//*[contains(text(),'View Cart')]"));
    private final Label cartInfo = new Label(By.xpath("//p[contains(text(), 'Your shopping cart is empty!')]"));
    //общие поля поиск панель
    private final TextField searchField = new TextField(By.xpath("//input[@name='search']"));
    private final Button searchButton = new Button(By.xpath("//button[@class='btn btn-default btn-lg']"));

    private static final String PRODUCT_THUMB_PATH = "//div[@class='product-thumb']";
    private static final String PRODUCT_NAME_PATH = "//h4//a";
    private static final String PRODUCT_COST_PATH = "//p[@class='price']";

    private static final String ADD_TO_CART_BUTTON_PATH = "//button[contains(@onclick,'cart.add')]";
    private Link productNameLink = new Link(By.xpath(String.format("%s%s", PRODUCT_THUMB_PATH, PRODUCT_NAME_PATH)));
    private Label productCostField = new Label(By.xpath(String.format("%s%s", PRODUCT_THUMB_PATH, PRODUCT_COST_PATH)));
    private Button addToCartButton = new Button(By
            .xpath(String.format("%s%s", PRODUCT_THUMB_PATH, ADD_TO_CART_BUTTON_PATH)));

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        if (!driver.getTitle().contains("Search")) {
            throw new IllegalStateException("This is not the Search page");
        }
    }

    public SearchResultsPage clickAddToCart() {
        addToCartButton.click();
        return this;
    }

    public String getProductNameFromThumb() {
        return productNameLink.getText();
    }

    public String getProductCostFromThumb() {
        String[] array = productCostField.getText().split("\n");
        return array[0];
    }

    //общее корзина
    public SearchResultsPage clickCartButton() {
        cartButton.click();
        return this;
    }

    //общее корзина
    public CartPage clickViewCartButton() {
        viewCartButton.click();
        return new CartPage(driver);
    }

    //общее панель поиска
    public SearchResultsPage clearAndTypeProductNameToSearchField(String productName) {
        searchField.clear();
        searchField.type(productName);
        return this;
    }

    //общее панель поиска
    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
