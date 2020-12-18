package register;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceEmailInvalidWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String emptyEmail = "";
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with empty email value",
            groups = {"all", "positive"})
    public void registration() {
        registrationScreen = new NavigatePanel()
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(text)
                .typeLastName(text)
                .typeEmail(emptyEmail)
                .typeTelephone(text)
                .typeFax(text)
                .typeCompany(text)
                .typeFirstAddress(text)
                .typeSecondAddress(text)
                .typeCity(text)
                .typePostcode(text)
                .selectRegion(region)
                .typePassword(text)
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicy();
        registrationScreen.clickContinueButton();
    }

    @Test(description = "***CheckAppearanceEmailInvalidWarning***\n" +
            "EPMFARMATS-13158: check appearance E-mail invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13158")
    public void checkAppearanceEmailInvalidWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(), "E-Mail Address does not appear to be valid!");
    }
}
