import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckCantOpenEmptyCart extends BaseTest {
    @Test
    public void checkOpenEmptyCart() {
        Boolean messageEmptyCartDisplayed = new HomePage(driver)
                .clickCartButton()
                .isCartDropDownEmptyMessageDisplayed();

        Assert.assertTrue(messageEmptyCartDisplayed, "The message from drop down cart menu isn't displayed!");
    }
}
