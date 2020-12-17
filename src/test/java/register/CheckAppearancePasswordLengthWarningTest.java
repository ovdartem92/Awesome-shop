package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearancePasswordLengthWarningTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String emptyPassword = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test
    public void checkAppearancePasswordLengthWarning() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationPage registrationScreen = navigatePanel
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(text)
                .typeLastName(text)
                .typeEmail(email)
                .typeTelephone(text)
                .typeFax(text)
                .typeCompany(text)
                .typeFirstAddress(text)
                .typeSecondAddress(text)
                .typeCity(text)
                .typePostcode(text)
                .selectRegion(region)
                .typePassword(emptyPassword)
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicy();
        registrationScreen.clickContinueButton();

        Assert.assertEquals(registrationScreen.getPasswordLengthWarning(), "Password must be between 4 and 20 characters!");
    }
}
