import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;

import java.util.List;

public class CheckRemoveProductFromCart extends BaseTest {
    public static final String MACBOOK = "MacBook";

    String PRODUCT_DIV_PATH = "//div[@class='product-thumb']";

    String ADD_TO_CART_BUTTON_PATH = "//button[contains(@onclick,'cart.add')]";
    TextField searchField = new TextField(By.xpath("//input[@name='search']"));
    Button searchButton = new Button(By.xpath("//button[@class='btn btn-default btn-lg']"));
    Button cartButton = new Button(By.xpath("//span[@id='cart-total']"));
    Button viewCartButton = new Button(By.xpath("//*[contains(text(),'View Cart')]"));
    Button removeProductButton = new Button(By.xpath("//button[@data-original-title='Remove']"));
    Label label = new Label(By.xpath("//div[@id='content']//*[contains(text(),'Your shopping cart is empty!')]"));
    @Test
    public void removeProduct () {
        searchField.clear();
        searchField.type(MACBOOK);
        searchButton.click();
        List<WebElement> product_div_1 = browser.getWrappedDriver().findElements(By.xpath(PRODUCT_DIV_PATH));
        System.out.println("LENGTH OF LIST_1: " + product_div_1.size());
        WebElement add_to_cart_button_first_product = product_div_1.get(0).findElement(By.xpath(String.format(".%s", ADD_TO_CART_BUTTON_PATH)));
        add_to_cart_button_first_product.click();
        cartButton.click();
        viewCartButton.click();
        System.out.println("LENGTH OF LIST_1: " + product_div_1.size());
        //здесь лучше тоже реализовать поиск кнопки относительно строки таблицы результатов
        removeProductButton.click();

        String emptyCartMessage = label.getText();

        Assert.assertEquals("Your shopping cart is empty!", emptyCartMessage, "The message isn't valid!");
    }

}
