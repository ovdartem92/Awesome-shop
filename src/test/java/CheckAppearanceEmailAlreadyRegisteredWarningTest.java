import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.BasePage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceEmailAlreadyRegisteredWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String previouslyRegisteredEmail = "kebikov1995@mail.ru";
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with already registered email",
            groups = {"all", "positive"})
    public void registration() {
        registrationScreen = new BasePage()
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(text)
                .typeLastName(text)
                .typeEmail(previouslyRegisteredEmail)
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

    @Test(description = "***CheckAppearanceEmailAlreadyRegisteredWarning***\n" +
            "EPMFARMATS-13166: check appearance E-mail already registered warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13166")
    public void checkAppearanceEmailAlreadyRegisteredWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(), "Warning: E-Mail Address is already registered!");
    }
}
