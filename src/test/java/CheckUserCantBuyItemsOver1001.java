import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckUserCantBuyItemsOver1001 extends BaseTest {
    @Test
    public void checkCantBuyOver1000() {
        String MACBOOK = "MacBook";
        String QUANTITY = "1001";
        Boolean isWarningQuantity = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .typeQuantity(QUANTITY)
                .clickUpdateProductButton()
                .clickCheckOutLink()
                .isQuantityWarningDisplayed();

        Assert.assertTrue(isWarningQuantity, "There is no warning about quantity on page!");
    }
}
