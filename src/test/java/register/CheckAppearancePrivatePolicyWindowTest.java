package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;

public class CheckAppearancePrivatePolicyWindowTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;

    @Test
    public void checkAppearancePrivatePolicyWindow() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationPage registrationScreen = navigatePanel
                .clickMyAccountLink()
                .clickRegistrationLink()
                .clickPrivacyPolicy();

        Assert.assertEquals(registrationScreen.getWarningMessage(), "Privacy Policy");
    }
}
