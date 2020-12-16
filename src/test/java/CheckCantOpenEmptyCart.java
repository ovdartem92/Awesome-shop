import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;

public class CheckCantOpenEmptyCart extends BaseConfigurationTest {
    @Test
    public void checkOpenEmptyCart() {
        CartFragment cartFragment = new CartFragment();
        cartFragment.clickCartButton();
        String messageFromCart = cartFragment.getCartDropDownEmptyMessage();

        Assert.assertEquals(messageFromCart, "Your shopping cart is empty!", "Messages aren't equals");
    }
}
