import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationScreen;
import ru.awesome.shop.ta.utils.StringUtils;

import static ru.awesome.shop.ta.product.pages.NavigatePanel.AccountLink.REGISTER;
import static ru.awesome.shop.ta.product.pages.registration.AccountRegistrationScreen.Field.POST_CODE;

public class CheckAppearancePostcodeLengthWarningTest extends BaseTest {
    private NavigatePanel navigatePanel;
    private String text = StringUtils.getRandomString();
    private String emptyPostCode = "";
    private String email = text.concat("@mail.ru");
    private String region = "Bristol";

    @Test
    public void checkAppearancePostcodeLengthWarning() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationScreen registrationScreen = navigatePanel.openAccountLinkScreen(REGISTER)
                .typeFirstName(text)
                .typeLastName(text)
                .typeEmail(email)
                .typeTelephone(text)
                .typeFax(text)
                .typeCompany(text)
                .typeFirstAddress(text)
                .typeSecondAddress(text)
                .typeCity(text)
                .typePostcode(emptyPostCode)
                .selectRegion(region)
                .typePassword(text)
                .typePasswordConfirm(text)
                .clickAgreeWithPrivacyPolicy();
        registrationScreen.clickContinueButton();

        Assert.assertTrue(registrationScreen.isFieldLengthWarning(POST_CODE));
    }
}
