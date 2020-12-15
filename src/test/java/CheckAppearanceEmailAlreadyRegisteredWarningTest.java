import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationScreen;
import ru.awesome.shop.ta.utils.StringUtils;

import static ru.awesome.shop.ta.product.pages.NavigatePanel.AccountLink.REGISTER;

public class CheckAppearanceEmailAlreadyRegisteredWarningTest extends BaseTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String previouslyRegisteredEmail = "kebikov1995@mail.ru";
    private String region = "Bristol";

    @Test
    public void checkAppearanceEmailAlreadyRegisteredWarning() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationScreen registrationScreen = navigatePanel.openAccountLinkScreen(REGISTER)
                .firstNameType(text)
                .lastNameType(text)
                .emailType(previouslyRegisteredEmail)
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

        Assert.assertEquals(registrationScreen.getDangerAlertMessage(),
                "Warning: E-Mail Address is already registered!");
    }
}
