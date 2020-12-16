import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.AccountPage;
import ru.awesome.shop.ta.product.pages.Header;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class LoginWithChangedPasswordTest extends BaseTest {
    private final User user = UserBuilder.getUserWithValidCredentials();
    private boolean accountLabelDisplayed;

    @BeforeClass(description = "login with valid credentials, change password, logout, login with new password")
    public void changePassword() {
        String newPassword = getRandomString();
        Header header = new Header();
        header.clickOnMyAccountLink().clickOnLoginLink()
                .typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickOnLoginButton().clickOnChangePasswordLink()
                .typeToPasswordTextField(newPassword).typeToConfirmPasswordTextField(newPassword)
                .clickOnContinueButton();
        header.clickOnMyAccountLink().clickOnLogoutLink();
        accountLabelDisplayed = header.clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(newPassword).clickOnLoginButton().isTextFromMyAccountLabelDisplayed();
    }

    @Test(description = "Check that user can login after changing password")
    public void loginWithChangedPassword() {
        Assert.assertTrue(accountLabelDisplayed, "User can not login after successfully changing password");
    }

    @AfterClass(description = "change password back")
    public void changePasswordBack() {
        new AccountPage().clickOnChangePasswordLink().typeToPasswordTextField(user.getPassword())
                .typeToConfirmPasswordTextField(user.getPassword()).clickOnContinueButton();
    }
}
