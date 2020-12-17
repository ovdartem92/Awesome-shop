package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceTelephoneLengthWarningTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String emptyTelephoneNumber = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test
    public void checkAppearanceTelephoneLengthWarning() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationPage registrationScreen = navigatePanel
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(text)
                .typeLastName(text)
                .typeEmail(email)
                .typeTelephone(emptyTelephoneNumber)
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

        Assert.assertEquals(registrationScreen.getTelephoneNumberLengthWarning(), "Telephone must be between 3 and 32 characters!");
    }
}
