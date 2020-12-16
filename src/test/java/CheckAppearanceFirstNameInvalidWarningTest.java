import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationScreen;
import ru.awesome.shop.ta.utils.StringUtils;

import static ru.awesome.shop.ta.product.pages.NavigatePanel.AccountLink.REGISTER;
import static ru.awesome.shop.ta.product.pages.registration.AccountRegistrationScreen.Field.FIRST_NAME;

public class CheckAppearanceFirstNameInvalidWarningTest extends BaseTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String invalidFirstName = text.concat("#");
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test
    public void checkAppearanceFirstNameInvalidWarning() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationScreen registrationScreen = navigatePanel.openAccountLinkScreen(REGISTER)
                .firstNameType(invalidFirstName)
                .lastNameType(text)
                .emailType(email)
                .telephoneType(text)
                .faxType(text)
                .companyType(text)
                .firstAddressType(text)
                .secondAddressType(text)
                .cityType(text)
                .postcodeType(text)
                .regionSelect(region)
                .passwordType(text)
                .passwordConfirmType(text)
                .agreeWithPrivacyPolicyClick();
        registrationScreen.continueButtonClick();

        Assert.assertTrue(registrationScreen.isFieldInvalidWarning(FIRST_NAME));
    }
}
