import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;

public class LoginWithInvalidEmailTest extends BaseTest {

    @Test(description = "check that user can not login with invalid email")
    public void loginWithInvalidEmail() {
        User user = UserBuilder.getUserWithInValidEmailAndValidPassword();
        boolean warningMessage = new Header().clickOnMyAccountLink().clickOnLoginLink()
                .typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButtonWithInvalidCredentials().isWarningMessageDisplayed();
        Assert.assertTrue(warningMessage, "User can login with invalid email and valid password");
    }
}
