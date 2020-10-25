import driver.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        String url = "https://www.skyscanner.net/";
        Browser.openPage(url);
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), url);
    }
}
