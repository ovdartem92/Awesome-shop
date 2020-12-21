import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.BasePage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceFirstNameInvalidWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String invalidFirstName = text.concat("$");
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with invalid first name value",
            groups = {"all", "negative"})
    public void registration() {
        registrationScreen = new BasePage()
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(invalidFirstName)
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

    @Test(description = "***CheckAppearanceFirstNameInvalidWarning***\n" +
            "EPMFARMATS-13181: check appearance First Name invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13181")
    public void checkAppearanceFirstNameInvalidWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(),
                "First Name shouldn't contains space character, special symbols, numerals");
    }
}
