import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckCorrectWorkContinueShoppingButton extends BaseTest {
    @Test
    public void checkCorrectContinueShopping() {
        String IPHONE = "Iphone";
        String homePageTitle = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(IPHONE)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .clickContinueShoppingButton()
                .getPageTitle();

        Assert.assertEquals(homePageTitle, "Your Store", "There is no Home Page in the end!");

    }
}
