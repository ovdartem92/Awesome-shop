package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckCanChangeQuantityLess1001AndBuy extends BaseConfigurationTest {
    @Test(description = "***CanChangeQuantityAndBuy***\n" +
            "EPMFARMATS-13149: Check that user can buy when product quantity less than 1001\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13149")
    public void checkCanBuyLess10001() {
        String MACBOOK = "MacBook";
        int QUANTITY = 666;
        SearchPanelFragment searchPanelFragment = new SearchPanelFragment();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        searchPanelFragment.typeProductName(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        cartPage.getAllCartItemsList().get(0).typeCartItemQuantity(QUANTITY);
        cartPage.clickCheckoutButton();
        String finishPageTitle = browser.getPageTitle();

        Assert.assertEquals(finishPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }
}
