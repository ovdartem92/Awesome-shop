package ru.awesome.shop.ta.product.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class CartItemFragment {
//    private String lineOfTablePath = "//div[@class='table-responsive']//tbody//tr[%s]";

    private WebElement element;

//    public CartItemFragment(int numberOfLine) {
//        this.lineOfTablePath = String.format(lineOfTablePath, numberOfLine + 1);
//    }

    public CartItemFragment(WebElement element) {
        this.element = element;
    }

    public String getCartItemName() {
        WebElement productNameLink = element.findElement(By.xpath(".//a[text()]"));
        //By productNameLinkLocator = By.xpath(lineOfTablePath + "//a[text()]");
        //Link productNameLink = new Link(productNameLinkLocator);
        return productNameLink.getText();
    }

    public String getCartItemUnitPrice() {
        WebElement productUnitPriceLabel = element.findElement(By.xpath(".//td[5]"));
        //By productUnitPriceLabelLocator = By.xpath(lineOfTablePath + "//td[5]");
        //Label productUnitPriceLabel = new Label(productUnitPriceLabelLocator);
        return productUnitPriceLabel.getText();
    }

    public CartItemFragment clickCartItemRemoveButton() {
        WebElement removeProductButton = element.findElement(By.xpath(".//button[@data-original-title='Remove']"));
//        By removeProductButtonLocator = By.xpath(lineOfTablePath + "//button[@data-original-title='Remove']");
//        Button removeProductButton = new Button(removeProductButtonLocator);
        removeProductButton.click();
        return this;
    }

    public CartItemFragment clickCartItemUpdateButton() {
        WebElement updateProductButton = element.findElement(By.xpath(".//button[@data-original-title='Update']"));
//        By updateProductButtonLocator = By.xpath(lineOfTablePath + "//button[@data-original-title='Update']");
//        Button updateProductButton = new Button(updateProductButtonLocator);
        updateProductButton.click();
        return this;
    }

    public CartItemFragment typeCartItemQuantity(int quantity) {
        WebElement quantityField = element.findElement(By.xpath(".//input[contains(@name, 'quantity')]"));
//        By quantityFieldLocator = By.xpath(lineOfTablePath + "//input[contains(@name, 'quantity')]");
//        TextField quantityField = new TextField(quantityFieldLocator);
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
        return this;
    }
}
