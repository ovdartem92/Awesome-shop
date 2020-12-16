import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckCorrectWorkContinueShoppingButton extends BaseTest {
    @Test
    public void checkCorrectContinueShopping() {
        String IPHONE = "Iphone";
        SearchFragment searchPanel = new SearchFragment(driver);
        CartFragment cartPanel = new CartFragment(driver);
        searchPanel.typeProductName(IPHONE);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        String finishPageTitle = cartPage.clickContinueShoppingButton()
                .getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }
}
