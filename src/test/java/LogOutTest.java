import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;

public class LogOutTest extends BaseTest {

    @Test(description = "check that user cat logout after successful login")
    public void checkThatUserCanLogout() {
        User user = UserBuilder.getUserWithValidCredentials();
        Header header = new Header();
        header.clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButton();
        boolean logout = header.clickOnMyAccountLink().clickOnLogoutLink().isLogOutLabelDisplayed();
        Assert.assertTrue(logout, "User can not logout");
    }
}
