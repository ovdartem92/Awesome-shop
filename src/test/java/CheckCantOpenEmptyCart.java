import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;

public class CheckCantOpenEmptyCart extends BaseConfigurationTest {
    @Test
    public void checkOpenEmptyCart() {
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        cartButtonFragment.clickCartButton();
        String messageFromCart = cartButtonFragment.getCartDropDownEmptyMessage();

        Assert.assertEquals(messageFromCart, "Your shopping cart is empty!", "Messages aren't equals");
    }
}
