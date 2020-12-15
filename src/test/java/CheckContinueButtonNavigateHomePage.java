import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.HomePage;

public class CheckContinueButtonNavigateHomePage extends BaseTest {
    @Test
    public void continueNavigateToHomePage() {
        String MACBOOK = "MacBook";
        String homePageTitle = new HomePage(driver)
                .clearAndTypeProductNameToSearchField(MACBOOK)
                .clickSearchButton()
                .clickAddToCart()
                .clickCartButton()
                .clickViewCartButton()
                .clickRemoveProductButton()
                .clickContinueButton()
                .getPageTitle();

        System.out.println(homePageTitle);

        Assert.assertEquals(homePageTitle, "Your Store", "There is no Home Page in the end!");
    }
}
