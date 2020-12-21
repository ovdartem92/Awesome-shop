import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.BasePage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceLastNameInvalidWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String invalidLastName = text.concat("$");
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with invalid last name value",
            groups = {"all", "negative"})
    public void registration() {
        registrationScreen = new BasePage()
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
                .clickAgreeWithPrivacyPolicyCheckbox();
        registrationScreen.clickContinueButton();
    }

    @Test(description = "***CheckAppearanceLastNameInvalidWarning***\n" +
            "EPMFARMATS-13182: check appearance Last Name invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13182")
    public void checkAppearanceLastNameInvalidWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(),
                "Last Name shouldn't contains space character, special symbols, numerals.");
    }
}
