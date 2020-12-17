package awesome.shop.tests.cart;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;
import ru.awesome.shop.ta.product.pages.fragments.CartButtonFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchPanelFragment;

public class CheckCanAddMoreThanOneProductToCart extends BaseConfigurationTest {
    @Test(description = "***CanAddMoreThanOneProductToCart***\n" +
            "EPMFARMATS-13150: Check that user can add more than one product to cart\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13150")
    public void checkAddToCartMoreProducts() {
        String MACBOOK = "MacBook";
        String IPHONE = "iPhone";
        SearchPanelFragment searchPanelFragment = new SearchPanelFragment();
        CartButtonFragment cartButtonFragment = new CartButtonFragment();
        searchPanelFragment.typeProductName(IPHONE);
        SearchResultsPage searchResultsPage = searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        searchPanelFragment.typeProductName(MACBOOK);
        searchPanelFragment.clickSearchButton();
        searchResultsPage.getSearchResultsList().get(0).clickAddToCartButton();
        cartButtonFragment.clickCartButton();
        CartPage cartPage = cartButtonFragment.clickViewCartButton();
        int sizeOfProductsList = cartPage.getAllCartItemsList().size();

        Assert.assertTrue(sizeOfProductsList > 1, "The size of products list isn't more 1! ");
    }
}