import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckUserCanAddMoreThanOneProductToCart extends BaseTest {
    @Test
    public void checkAddToCartMoreProducts() {
        String MACBOOK = "MacBook";
        String IPHONE = "iPhone";
        Boolean isProductListMoreThanOne = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clearAndTypeProductNameToSearchField(IPHONE)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .isCartContainsMoreThanOneProduct();

        Assert.assertTrue(isProductListMoreThanOne, "The size of products list isn't more 1! ");
    }
}