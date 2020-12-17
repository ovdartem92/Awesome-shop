package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceCityLengthWarningTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String emptyCity = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test(description = "***CheckAppearanceCityLengthWarning***\n" +
            "EPMFARMATS-13161: check appearance City length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13161")
    public void checkAppearanceCityLengthWarning() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationPage registrationScreen = navigatePanel
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
                .typeCity(emptyCity)
                .typePostcode(text)
                .selectRegion(region)
                .typePassword(text)
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicy();
        registrationScreen.clickContinueButton();

        Assert.assertEquals(registrationScreen.getWarningMessage(), "City must be between 2 and 128 characters!");
    }
}
