package register;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationPage;

public class CheckAppearancePrivatePolicyWindowTest extends BaseConfigurationTest {
    private NavigatePanel navigatePanel;

    @Test(description = "***CheckAppearancePrivatePolicyWindow***\n" +
            "EPMFARMATS-13167: check appearance Private Policy window\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13167")
    public void checkAppearancePrivatePolicyWindow() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationPage registrationScreen = navigatePanel
                .clickMyAccountLink()
                .clickRegistrationLink()
                .clickPrivacyPolicy();

        Assert.assertEquals(registrationScreen.getPrivacyPolicyTitle(), "Privacy Policy");
    }
}
