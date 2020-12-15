import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckUserCanChangeQuantity extends BaseTest {
    @Test
    public void checkCantBuyZero() {
        String MACBOOK = "MacBook";
        String QUANTITY = "56";
        String quantityFromCartButton = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .typeQuantity(QUANTITY)
                .clickUpdateProductButton()
                .getQuantityFromCartButton();

        Assert.assertEquals(quantityFromCartButton, QUANTITY, "The values of quantity aren't equals!");
    }
}
