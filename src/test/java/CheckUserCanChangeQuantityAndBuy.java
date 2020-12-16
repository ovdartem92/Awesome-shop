import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.CartPanel;
import ru.awesome.shop.ta.product.pages.SearchPanel;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckUserCanChangeQuantityAndBuy extends BaseTest {
    @Test
    public void checkCanBuyLess1000() {
        String MACBOOK = "MacBook";
        String QUANTITY = "500";
        SearchPanel searchPanel = new SearchPanel(driver);
        CartPanel cartPanel = new CartPanel(driver);
        searchPanel.clearAndTypeProductNameToSearchField(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCart();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        cartPage.typeQuantity(QUANTITY);
        String finishPageTitle = cartPage.clickCheckout1Button()
                .getPageTitle();

        Assert.assertEquals(finishPageTitle, "Checkout", "There is no Checkout Page in the end!");
    }
}
