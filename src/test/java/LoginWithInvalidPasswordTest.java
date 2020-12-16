import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;

public class LoginWithInvalidPasswordTest extends BaseConfigurationTest {
    private boolean warningMessageDisplayed;

    @BeforeClass(description = "login with valid email and invalid password")
    public void login() {
        User user = UserBuilder.getUserWithValidEmailAndInvalidPassword();
        warningMessageDisplayed = new Header().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButtonWithInvalidCredentials().isWarningMessageDisplayed();
    }

    @Test(description = "check that user can not login with invalid password")
    public void loginWithInvalidEmail() {
        Assert.assertTrue(warningMessageDisplayed, "User can login with valid email and valid password");
    }
}
