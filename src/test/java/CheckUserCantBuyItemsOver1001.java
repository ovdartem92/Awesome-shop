import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.CartPanel;
import ru.awesome.shop.ta.product.pages.SearchPanel;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckUserCantBuyItemsOver1001 extends BaseTest {
    @Test
    public void checkCantBuyOver1000() {
        String MACBOOK = "MacBook";
        String QUANTITY = "1001";
        SearchPanel searchPanel = new SearchPanel(driver);
        CartPanel cartPanel = new CartPanel(driver);
        searchPanel.clearAndTypeProductNameToSearchField(MACBOOK);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCart();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        cartPage.typeQuantity(QUANTITY);
        cartPage.clickUpdateProductButton();
        cartPage.clickCheckOutButtonStayOnCart();
        Boolean warningQuantityDisplayed = cartPage.isQuantityWarningDisplayed();

        Assert.assertTrue(warningQuantityDisplayed, "There is no warning about quantity on page!");
    }
}
