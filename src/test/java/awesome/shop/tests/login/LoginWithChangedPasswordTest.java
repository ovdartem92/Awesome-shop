package awesome.shop.tests.login;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.MainPage;
import ru.awesome.shop.ta.product.pages.login.AccountPage;
import ru.awesome.shop.ta.product.pages.login.LogoutPage;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class LoginWithChangedPasswordTest extends BaseConfigurationTest {
    private final User user = UserFactory.getUserWithValidCredentials();
    private String accountLabelText;

    @BeforeMethod(description = "login with valid credentials, change password, logout, login with new password",
            groups = {"all", "positive"})
    public void changePassword() {
        String newPassword = getRandomString();
        new MainPage().clickOnMyAccountLink().clickOnLoginLink()
                .typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButton().clickChangePasswordLink()
                .typePassword(newPassword).typeConfirmationPassword(newPassword)
                .clickContinueButton();
        new AccountPage().clickOnMyAccountLink().clickOnLogoutLink();
        accountLabelText = new LogoutPage().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(newPassword).clickLoginButton().getTextFromMyAccountLabel();
    }

    @Test(description = "***LoginAfterChangingPassword***\n"+
            "Check that user can login after changing password",
            groups = {"all", "positive"})
    public void loginWithChangedPassword() {
        Assert.assertEquals(accountLabelText, "My Account",
                "User can not login after successfully changing password");
    }

    @AfterMethod(description = "change password back",
            groups = {"all", "positive"})
    public void changePasswordBack() {
        new AccountPage().clickChangePasswordLink().typePassword(user.getPassword())
                .typeConfirmationPassword(user.getPassword()).clickContinueButton();
    }
}
