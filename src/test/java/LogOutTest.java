import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;

public class LogOutTest extends BaseTest {
    private boolean logoutLabelDisplayed;

    @BeforeClass(description = "login with valid credentials and then logout")
    public void logout() {
        User user = UserBuilder.getUserWithValidCredentials();
        Header header = new Header();
        header.clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButton();
        logoutLabelDisplayed = header.clickOnMyAccountLink().clickOnLogoutLink().isLogOutLabelDisplayed();
    }

    @Test(description = "check that user cat logout after successful login")
    public void checkThatUserCanLogout() {
        Assert.assertTrue(logoutLabelDisplayed, "User can not logout");
    }
}
