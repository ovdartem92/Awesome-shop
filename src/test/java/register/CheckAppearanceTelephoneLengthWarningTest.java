package register;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceTelephoneLengthWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String emptyTelephoneNumber = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with empty telephone number",
            groups = {"all", "positive"})
    public void registration() {
        registrationScreen = new NavigatePanel()
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(text)
                .typeLastName(text)
                .typeEmail(email)
                .typeTelephone(emptyTelephoneNumber)
                .typeFax(text)
                .typeCompany(text)
                .typeFirstAddress(text)
                .typeSecondAddress(text)
                .typeCity(text)
                .typePostcode(text)
                .selectRegion(region)
                .typePassword(text)
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicyCheckbox();
        registrationScreen.clickContinueButton();
    }

    @Test(description = "***CheckAppearanceTelephoneLengthWarning***\n" +
            "EPMFARMATS-13159: check appearance Telephone length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13159")
    public void checkAppearanceTelephoneLengthWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(), "Telephone must be between 3 and 32 characters!");
    }
}
