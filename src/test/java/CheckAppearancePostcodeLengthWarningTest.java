import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.BasePage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearancePostcodeLengthWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String emptyPostCode = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with empty postcode value",
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
                .typePostcode(emptyPostCode)
                .selectRegion(region)
                .typePassword(text)
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicyCheckbox();
        registrationScreen.clickContinueButton();
    }

    @Test(description = "***CheckAppearancePostcodeLengthWarning***\n" +
            "EPMFARMATS-13163: check appearance Postcode length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13163")
    public void checkAppearancePostcodeLengthWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(), "Postcode must be between 2 and 10 characters!");
    }
}
