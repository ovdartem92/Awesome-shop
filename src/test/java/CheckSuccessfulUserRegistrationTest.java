import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationSuccessfullyScreen;
import ru.awesome.shop.ta.utils.StringUtils;

import static ru.awesome.shop.ta.product.pages.NavigatePanel.AccountLink.REGISTER;

public class CheckSuccessfulUserRegistrationTest extends BaseTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test
    public void checkSuccessfulUserRegistration() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationSuccessfullyScreen registrationScreen = navigatePanel.openAccountLinkScreen(REGISTER)
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

        Assert.assertEquals(registrationScreen.getAccountCreatedLabelText(), "Your Account Has Been Created!");
    }
}
