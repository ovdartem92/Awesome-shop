package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceLastNameInvalidWarningTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String invalidLastName = text.concat("$");
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test(description = "***CheckAppearanceLastNameInvalidWarning***\n" +
            "EPMFARMATS-13182: check appearance Last Name invalid warning\n\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13182")
    public void checkAppearanceLastNameInvalidWarning() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationPage registrationScreen = navigatePanel
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(invalidLastName)
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
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicy();
        registrationScreen.clickContinueButton();

        Assert.assertEquals(registrationScreen.getWarningMessage(),
                "Last Name shouldn't contains space character, special symbols, numerals.");
    }
}
