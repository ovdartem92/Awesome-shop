package register;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceTelephoneInvalidWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String invalidTelephone = text.concat("$");
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with invalid telephone number",
            groups = {"all", "negative"})
    public void registration() {
        registrationScreen = new NavigatePanel()
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(text)
                .typeLastName(text)
                .typeEmail(email)
                .typeTelephone(invalidTelephone)
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

    @Test(description = "***CheckAppearanceTelephoneInvalidWarning***\n" +
            "EPMFARMATS-13183: check appearance Telephone invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13183")
    public void checkAppearanceTelephoneInvalidWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(),
                "Last Name shouldn't contains space character, special symbols, numerals.");
    }
}
