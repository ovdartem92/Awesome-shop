import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.BasePage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearancePasswordLengthWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String emptyPassword = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with empty password value",
            groups = {"all", "positive"})
    public void registration() {
        registrationScreen = new BasePage()
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
                .clickAgreeWithPrivacyPolicyCheckbox();
        registrationScreen.clickContinueButton();
    }

    @Test(description = "***CheckAppearancePasswordLengthWarning***\n" +
            "EPMFARMATS-13164: check appearance Password length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13164")
    public void checkAppearancePasswordLengthWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(), "Password must be between 4 and 20 characters!");
    }
}
