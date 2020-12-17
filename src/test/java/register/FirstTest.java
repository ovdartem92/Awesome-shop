package register;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseConfigurationTest {

    @Test
    public void openUrl() {
        Assert.assertEquals(browser.getWrappedDriver().getCurrentUrl(), URL);
    }
}

