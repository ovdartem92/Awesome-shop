package register;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceLastNameLengthWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String emptyLastName = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with empty last name value",
            groups = {"all", "positive"})
    public void registration() {
        registrationScreen = new NavigatePanel()
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(text)
                .typeLastName(emptyLastName)
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
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicy();
        registrationScreen.clickContinueButton();
    }

    @Test(description = "***CheckAppearanceLastNameLengthWarning***\n" +
            "EPMFARMATS-13157: check appearance Last Name length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13157")
    public void checkAppearanceLastNameLengthWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(), "Last Name must be between 1 and 32 characters!");
    }
}
