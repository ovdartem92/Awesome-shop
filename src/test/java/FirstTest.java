import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void openUrl() {
        Assert.assertEquals(browser.getWrappedDriver().getCurrentUrl(), URL);
    }
}

