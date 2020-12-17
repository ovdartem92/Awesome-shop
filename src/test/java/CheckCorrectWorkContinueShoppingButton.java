import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckCorrectWorkContinueShoppingButton extends BaseConfigurationTest {
    @Test(description = "***CorrectWorkContinueShoppingButton***\n" +
            "EPMFARMATS-13175: Check that 'Continue shopping' button in cart page work correctly\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13175")
    public void checkCorrectContinueShopping() {
        String IPHONE = "Iphone";
        SearchPanelFragment searchPanelFragment = new SearchPanelFragment();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        searchPanelFragment.typeProductName(IPHONE);
        SearchResultsPage searchResultsPage = searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.clickContinueShoppingButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }
}
