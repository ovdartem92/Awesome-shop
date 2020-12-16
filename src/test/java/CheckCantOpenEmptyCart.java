import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPanel;

public class CheckCantOpenEmptyCart extends BaseTest {
    @Test
    public void checkOpenEmptyCart() {
        CartPanel cartPanel = new CartPanel(driver);
        cartPanel.clickCartButton();
        Boolean messageEmptyCartDisplayed = cartPanel.isCartDropDownEmptyMessageDisplayed();
        Assert.assertTrue(messageEmptyCartDisplayed, "The message from drop down cart menu isn't displayed!");
    }
}
