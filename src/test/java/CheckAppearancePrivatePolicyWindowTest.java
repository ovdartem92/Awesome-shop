import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.NavigatePanel;
import ru.awesome.shop.ta.product.pages.registration.AccountRegistrationScreen;

import static ru.awesome.shop.ta.product.pages.NavigatePanel.AccountLink.REGISTER;

public class CheckAppearancePrivatePolicyWindowTest extends BaseTest {
    private NavigatePanel navigatePanel;

    @Test
    public void checkAppearancePrivatePolicyWindow() {
        navigatePanel = new NavigatePanel();
        AccountRegistrationScreen registrationScreen = navigatePanel.openAccountLinkScreen(REGISTER)
                .clickPrivacyPolicy();

        Assert.assertTrue(registrationScreen.isDisplayedPrivacyPolicyWindow());
    }
}
