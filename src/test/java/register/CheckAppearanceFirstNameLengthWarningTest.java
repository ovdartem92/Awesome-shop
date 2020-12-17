package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;
import ru.awesome.shop.ta.utils.StringUtils;

public class CheckAppearanceFirstNameLengthWarningTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String emptyFirstName = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test
    public void checkAppearanceFirstNameLengthWarning() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationPage registrationScreen = navigatePanel
                .clickMyAccountLink()
                .clickRegistrationLink()
                .typeFirstName(emptyFirstName)
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

        Assert.assertEquals(registrationScreen.getFirstNameLengthWarning(), "First Name must be between 1 and 32 characters!");
    }
}
