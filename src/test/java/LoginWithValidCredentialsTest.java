import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;

public class LoginWithValidCredentialsTest extends BaseTest {

    @Test(description = "check than user can login with correct email and password")
    public void loginWithValidCredentialsTest() {
        User user = UserBuilder.getUserWithValidCredentials();
        boolean myAccount = new Header().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButton().isTextFromMyAccountLabelDisplayed();
        Assert.assertTrue(myAccount, "User with valid login and password can not login");
    }
}
