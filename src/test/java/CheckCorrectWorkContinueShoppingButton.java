import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.CartPanel;
import ru.awesome.shop.ta.product.pages.SearchPanel;
import ru.awesome.shop.ta.product.pages.SearchResultsPage;

public class CheckCorrectWorkContinueShoppingButton extends BaseTest {
    @Test
    public void checkCorrectContinueShopping() {
        String IPHONE = "Iphone";
        SearchPanel searchPanel = new SearchPanel(driver);
        CartPanel cartPanel = new CartPanel(driver);
        searchPanel.clearAndTypeProductNameToSearchField(IPHONE);
        SearchResultsPage searchResultsPage = searchPanel.clickSearchButton();
        searchResultsPage.clickAddToCart();
        cartPanel.clickCartButton();
        CartPage cartPage = cartPanel.clickViewCartButton();
        String finishPageTitle = cartPage.clickContinueShoppingButton()
                .getPageTitle();

        Assert.assertEquals(finishPageTitle, "Your Store", "There is no Home Page in the end!");
    }
}
