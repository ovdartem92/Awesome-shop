import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;

public class LoginWithInvalidEmailTest extends BaseTest {
    private boolean warningMessageDisplayed;

    @BeforeClass(description = "login with invalid email and valid password")
    public void login() {
        User user = UserBuilder.getUserWithInValidEmailAndValidPassword();
        warningMessageDisplayed = new Header().clickOnMyAccountLink().clickOnLoginLink()
                .typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButtonWithInvalidCredentials()
                .isWarningMessageDisplayed();
    }

    @Test(description = "check that user can not login with invalid email")
    public void loginWithInvalidEmail() {
        Assert.assertTrue(warningMessageDisplayed, "User can login with invalid email and valid password");
    }
}
