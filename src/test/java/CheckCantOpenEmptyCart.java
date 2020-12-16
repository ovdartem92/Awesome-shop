import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;

public class CheckCantOpenEmptyCart extends BaseTest {
    @Test
    public void checkOpenEmptyCart() {
        CartFragment cartPanel = new CartFragment(driver);
        cartPanel.clickCartButton();
        Boolean messageEmptyCartDisplayed = cartPanel.getCartDropDownEmptyMessage();
        Assert.assertTrue(messageEmptyCartDisplayed, "The message from drop down cart menu isn't displayed!");
    }
}
