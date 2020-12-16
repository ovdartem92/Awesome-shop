import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;

public class LoginWithValidCredentialsTest extends BaseConfigurationTest {
    private boolean myAccountLabelDisplayed;

    @BeforeClass(description = "login with valid email and valid password")
    public void login() {
        User user = UserBuilder.getUserWithValidCredentials();
        myAccountLabelDisplayed = new Header().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButton().isTextFromMyAccountLabelDisplayed();
    }

    @Test(description = "check than user can login with correct email and password")
    public void loginWithValidCredentialsTest() {
        Assert.assertTrue(myAccountLabelDisplayed, "User with valid login and password can not login");
    }
}
