package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationSuccessfullyPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckSuccessfulUserRegistrationTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test(description = "***CheckSuccessfulUserRegistration***\n" +
            "EPMFARMATS-13155: check successful user registration\n\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13155")
    public void checkSuccessfulUserRegistration() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationSuccessfullyPage registrationScreen = navigatePanel
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
                .typePassword(text)
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicy()
                .clickContinueButton();

        Assert.assertEquals(registrationScreen.getAccountCreationMessage(), "Your Account Has Been Created!");
    }
}
