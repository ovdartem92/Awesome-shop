import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.fragments.CartFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckContinueButtonNavigateHomePage extends BaseTest {
    @Test
    public void continueNavigateToHomePage() {
        String MACBOOK = "MacBook";
        SearchFragment searchPanel = new SearchFragment(driver);
        CartFragment cartPanel = new CartFragment(driver);
        searchPanel.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCartButton();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        String finishPageTitle = cartPage.clickRemoveProductButton()
                .clickContinueButton()
                .getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }
}
