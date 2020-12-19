package register;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.MainPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceCityInvalidWarningTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;
    private String text = StringUtils.getRandomString();
    private String invalidCity = text.concat("$");
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @BeforeMethod(description = "user registration with invalid city value",
            groups = {"all", "negative"})
    public void registration() {
        registrationScreen = new MainPage()
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
                .typeCity(invalidCity)
                .typePostcode(text)
                .selectRegion(region)
                .typePassword(text)
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicyCheckbox();
        registrationScreen.clickContinueButton();
    }

    @Test(description = "***CheckAppearanceCityInvalidWarning***\n" +
            "EPMFARMATS-13184: check appearance City invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13184")
    public void checkAppearanceCityInvalidWarning() {
        Assert.assertEquals(registrationScreen.getWarningMessage(), "City shouldn't contains special symbols and numerals!");
    }
}
