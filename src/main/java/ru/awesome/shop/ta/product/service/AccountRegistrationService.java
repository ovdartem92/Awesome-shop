package ru.awesome.shop.ta.product.service;

import org.apache.commons.lang3.StringUtils;
import ru.awesome.shop.ta.framework.exceptions.RegistrationException;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.address.Region;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.SuccessfulAccountRegistrationPage;

import java.util.List;

public class AccountRegistrationService {
    private final AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage();

    public void fillInRegistrationForm(User user) {
        Credentials credentials = user.getCredentials();
        ContactInfo contactInfo = user.getContactInfo();
        Address address = user.getContactInfo().getAddress();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String company = user.getCompanyName();
        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String telephoneNumber = contactInfo.getTelephoneNumber();
        String faxNumber = contactInfo.getFaxNumber();
        String firstAddress = address.getFirstAddress();
        String secondAddress = address.getSecondAddress();
        String country = address.getCountry();
        Region region = address.getRegion();
        String city = address.getCity();
        String postCode = address.getPostCode();

        accountRegistrationPage.typeFirstName(firstName);
        accountRegistrationPage.typeLastName(lastName);
        accountRegistrationPage.typeEmail(email);
        accountRegistrationPage.typeTelephone(telephoneNumber);
        accountRegistrationPage.typeFax(faxNumber);
        accountRegistrationPage.typeCompany(company);
        accountRegistrationPage.typeFirstAddress(firstAddress);
        accountRegistrationPage.typeSecondAddress(secondAddress);
        accountRegistrationPage.typeCity(city);
        accountRegistrationPage.typePostcode(postCode);
        accountRegistrationPage.selectRegion(region);
        accountRegistrationPage.typePassword(password);
        accountRegistrationPage.typePasswordConfirm(password);
    }

    public SuccessfulAccountRegistrationPage register(User user) throws RegistrationException {
        fillInRegistrationForm(user);
        accountRegistrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        accountRegistrationPage.clickContinueButton();
        List<String> errorMessages = accountRegistrationPage.getAllErrorMessages();

        if(errorMessages.size() > 0) {
            throw new RegistrationException("Registration failed:\n" + StringUtils.join(errorMessages, "\n"));
        }
        return new SuccessfulAccountRegistrationPage();
    }
}
