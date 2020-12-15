import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.AccountPage;
import ru.awesome.shop.ta.product.pages.Header;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class LoginWithChangedPasswordTest extends BaseTest {
    private User user = UserBuilder.getUserWithValidCredentials();

    @Test(description = "Check that user can login after changing password")
    public void loginWithChangedPassword() {
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

    @AfterClass(description = "change password back")
    public void changePasswordBack() {
        new AccountPage().clickOnChangePasswordLink().typeToPasswordTextField(user.getPassword())
                .typeToConfirmPasswordTextField(user.getPassword()).clickOnContinueButton();
    }
}
