import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckItemIntoCartTest extends BaseTest {
    @Test
    public void checkItemIntoCart() {
        String MACBOOK = "MacBook";
        String resultProduct = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .getNameOfFirstProductIntoCart();

        Assert.assertEquals(MACBOOK, resultProduct, "The values of product aren't equal!");
    }

}
