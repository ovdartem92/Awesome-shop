package register;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.MainPage;

public class CheckAppearancePrivatePolicyWindowTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationScreen;

    @BeforeMethod(description = "open privacy policy window on page registration",
            groups = {"all", "positive"})
    public void registration() {
        registrationScreen = new MainPage()
                .clickMyAccountLink()
                .clickRegistrationLink()
                .clickPrivacyPolicyLink();
    }

    @Test(description = "***CheckAppearancePrivatePolicyWindow***\n" +
            "EPMFARMATS-13167: check appearance Private Policy window\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13167")
    public void checkAppearancePrivatePolicyWindow() {
        Assert.assertEquals(registrationScreen.getPrivacyPolicyTitle(), "Privacy Policy");
    }
}
