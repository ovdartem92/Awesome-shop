import driver.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbstractPage;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), AbstractPage.getHomepageUrl(), "Url isn't correct");
    }
}
