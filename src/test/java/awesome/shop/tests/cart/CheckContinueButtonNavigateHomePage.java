package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckContinueButtonNavigateHomePage extends BaseConfigurationTest {
    @Test(description = "***ContinueButtonNavigateToHomePage***\n" +
            "EPMFARMATS-13151: Check that 'Continue' button in empty cart lead to main page\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13151")
    public void continueNavigateToHomePage() {
        String MACBOOK = "MacBook";
        SearchPanelFragment searchPanelFragment = new SearchPanelFragment();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        searchPanelFragment.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.getAllCartItemsList().get(0).clickCartItemRemoveButton();
        cartPage.clickContinueButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }
}
