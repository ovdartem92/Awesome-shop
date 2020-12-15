import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckUserCanChangeQuantityAndBuy extends BaseTest {
    @Test
    public void checkCanBuyLess1000() {
        String MACBOOK = "MacBook";
        String QUANTITY = "500";
        String checkoutPageTitle = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .typeQuantity(QUANTITY)
                .clickCheckout1Button()
                .getPageTitle();

        Assert.assertEquals(checkoutPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }
}
