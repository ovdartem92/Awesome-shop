import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckItemIntoCartTest extends BaseTest {

    public static final String MACBOOK = "MacBook";

    @Test
    public void checkItemIntoCart() {

        String resultProduct = new HomePage(browser.getWrappedDriver())
                .typeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .getNameOfFirstProductIntoCart();

        Assert.assertEquals(MACBOOK, resultProduct, "The values of product aren't equal!");
    }

}
