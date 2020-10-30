import driver.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test()
    public void firstTest() {
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), URL, "Url isn't correct");
    }
}
