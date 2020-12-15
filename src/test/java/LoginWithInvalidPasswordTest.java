import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;

public class LoginWithInvalidPasswordTest extends BaseTest {
    @Test(description = "check that user can not login with invalid password")
    public void loginWithInvalidEmail() {
        User user = UserBuilder.getUserWithValidEmailAndInvalidPassword();
        boolean warningMessage = new Header().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButtonWithInvalidCredentials().isWarningMessageDisplayed();
        Assert.assertTrue(warningMessage, "User can login with valid email and valid password");
    }
}
