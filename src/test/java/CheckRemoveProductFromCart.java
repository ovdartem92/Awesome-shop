import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckRemoveProductFromCart extends BaseTest {
    @Test
    public void removeProduct() {
        String MACBOOK = "MacBook";
        Boolean messageEmptyCartDisplayed = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .clickRemoveProductButton()
                .isEmptyShoppingCartMessageDisplayed();

        Assert.assertTrue(messageEmptyCartDisplayed, "Message isn't displayed after removing product from cart!");
    }

}
