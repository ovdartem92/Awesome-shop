import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckUserCantBuyZeroItems extends BaseTest {
    @Test
    public void checkCantBuyZero() {
        String MACBOOK = "MacBook";
        String QUANTITY = "0";
        Boolean messageEmptyCartDisplayed = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .typeQuantity(QUANTITY)
                .clickUpdateProductButton()
                .isEmptyShoppingCartMessageDisplayed();

        Assert.assertTrue(messageEmptyCartDisplayed, "Message isn't displayed after update!");
    }
}
