package login;

import BaseTest.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.MainPage;
import ru.awesome.shop.ta.product.pages.login.AccountPage;
import ru.awesome.shop.ta.product.pages.login.LogoutPage;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class LoginWithChangedPasswordTest extends BaseConfigurationTest {
    private final User user = UserBuilder.getUserWithValidCredentials();
    private String accountLabelText;

    @BeforeMethod(description = "login with valid credentials, change password, logout, login with new password")
    public void changePassword() {
        String newPassword = getRandomString();
        new MainPage().clickOnMyAccountLink().clickOnLoginLink()
                .typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButton().clickChangePasswordLink()
                .typeToPasswordTextField(newPassword).typeToConfirmPasswordTextField(newPassword)
                .clickContinueButton();
        new AccountPage().clickOnMyAccountLink().clickOnLogoutLink();
        accountLabelText = new LogoutPage().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(newPassword).clickLoginButton().getTextFromMyAccountLabel();
    }

    @Test(description = "Check that user can login after changing password")
    public void loginWithChangedPassword() {
        Assert.assertEquals(accountLabelText, "My Account",
                "User can not login after successfully changing password");
    }

    @AfterMethod(description = "change password back")
    public void changePasswordBack() {
        new AccountPage().clickChangePasswordLink().typeToPasswordTextField(user.getPassword())
                .typeToConfirmPasswordTextField(user.getPassword()).clickContinueButton();
    }
}
