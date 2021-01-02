package awesome.shop.tests.cucumber.steps.registration;

import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;

import static java.lang.String.format;

public class UserRegistrationFactory {

    protected static User getUser(String type) {
        User user;
        switch (type) {
            case "validUser":
                user = UserFactory.generateValidUser();
                break;
            case "emptyUser":
                Credentials credentials = CredentialsFactory.generateEmptyCredentials();
                user = new User.Builder(credentials).build();
                break;
            case "registeredUser":
                User validUser = UserFactory.generateValidUser();
                String validFirstName = validUser.getFirstName();
                String validLastName = validUser.getLastName();
                String validCompanyName = validUser.getCompanyName();
                ContactInfo validContactInfo = validUser.getContactInfo();
                String registeredEmail = PropertyManager.getEmail();
                String registeredPassword = PropertyManager.getPassword();
                Credentials registeredCredentials = new Credentials(registeredEmail, registeredPassword);

                user = new User.Builder(registeredCredentials).firstName(validFirstName)
                        .lastName(validLastName).companyName(validCompanyName).contactInfo(validContactInfo).build();
                break;
            case "userWithInvalidFirstName":
                user = UserFactory.generateUserWithInvalidFirstName();
                break;
            case "userWithInvalidLastName":
                user = UserFactory.generateUserWithInvalidLastName();
                break;
            case "userWithInvalidCity":
                user = UserFactory.generateUserWithInvalidCity();
                break;
            case "userWithInvalidTelephone":
                user = UserFactory.generateUserWithInvalidTelephone();
                break;
            default:
                throw new IllegalArgumentException(format("Unexpected user type: %s", type));
        }
        return user;
    }
}
