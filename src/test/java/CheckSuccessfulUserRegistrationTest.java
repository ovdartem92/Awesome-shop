import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationScreen;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationSuccessfullyScreen;
import ru.awesome.shop.ta.utils.StringUtils;

import static ru.awesome.shop.ta.product.pages.NavigatePanel.AccountLink.REGISTER;

public class CheckSuccessfulUserRegistrationTest extends BaseTest {
    private NavigatePanel navigatePanel;
    private AccountRegistrationScreen registrationScreen;
    private String text = StringUtils.getRandomString();
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test
    public void CheckSuccessfulUserRegistration() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationSuccessfullyScreen registrationScreen = navigatePanel.openAccountLinkScreen(REGISTER)
                .firstNameType(text)
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
                .agreeWithPrivacyPolicyClick()
                .continueButtonClick();

        Assert.assertEquals(registrationScreen.getAccountCreatedLabelText(), "Your Account Has Been Created!");
    }
}
