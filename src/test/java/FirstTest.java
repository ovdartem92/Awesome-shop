import org.testng.Assert;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;

public class FirstTest extends BaseTest {

    @Test
    public void openUrl() {
        User user = UserFactory.generateValidUser();
        System.out.println("EMAIL: " + user.getCredentials().getEmail());
        System.out.println("PASSWORD: " + user.getCredentials().getPassword());
        System.out.println("FIRST NAME: " + user.getFirstName());
        System.out.println("LAST NAME: " + user.getLastName());
        System.out.println("COMPANY: " + user.getCompanyName());
        System.out.println("TELEPHONE: " + user.getContactInfo().getTelephoneNumber());
        System.out.println("FAX: " + user.getContactInfo().getFaxNumber());
        System.out.println("ADDRESS 1: " + user.getContactInfo().getAddress().getFirstAddress());
        System.out.println("ADDRESS 2: " + user.getContactInfo().getAddress().getSecondAddress());
        System.out.println("CITY: " + user.getContactInfo().getAddress().getCity());
        System.out.println("POSTCODE: " + user.getContactInfo().getAddress().getPostCode());
        System.out.println("COUNTRY: " + user.getContactInfo().getAddress().getCountry());
        System.out.println("REGION: " + user.getContactInfo().getAddress().getRegion());

        Assert.assertEquals(browser.getWrappedDriver().getCurrentUrl(), URL);
    }
}

