import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.Header;
import ru.awesome.shop.ta.utils.TestDataReader;

import java.io.IOException;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class LoginWithChangedPasswordTest extends BaseTest {
    @Test(description = "Check that user can login after changing password")
    public void loginWithChangedPassword() throws IOException {
        User user = UserBuilder.getUserWithValidCredentials();
        String newPassword = getRandomString();
        new Header().clickOnMyAccountLink().clickOnLoginLink()
                .typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButton().clickOnChangePasswordLink()
                .typeToPasswordTextField(newPassword).typeToConfirmPasswordTextField(newPassword)
                .clickOnContinueButton();
        new Header().clickOnMyAccountLink().clickOnLogoutLink();
        boolean accountLabel = new Header().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(newPassword).clickOnLoginButton().isTextFromMyAccountLabelDisplayed();
        Assert.assertTrue(accountLabel, "User can not login after successfully changing password");
    }
}
