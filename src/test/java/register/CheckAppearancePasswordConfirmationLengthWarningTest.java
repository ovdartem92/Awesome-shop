package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearancePasswordConfirmationLengthWarningTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String emptyPasswordConfirm = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test(description = "***CheckAppearancePasswordConfirmationLengthWarning***\n" +
            "EPMFARMATS-13165: check appearance Password Confirmation warning\n\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13165")
    public void checkAppearancePasswordConfirmationLengthWarning() {
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
                .typePassword(text)
                .typePasswordConfirm(emptyPasswordConfirm)
                .clickAgreeWithPrivacyPolicy();
        registrationScreen.clickContinueButton();

        Assert.assertEquals(registrationScreen.getWarningMessage(), "Password confirmation does not match password!");
    }
}
