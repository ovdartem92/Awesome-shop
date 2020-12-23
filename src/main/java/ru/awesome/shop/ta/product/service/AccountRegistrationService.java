package ru.awesome.shop.ta.product.service;

import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.address.Region;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.SuccessfulAccountRegistrationPage;

public class AccountRegistrationService {
    private AccountRegistrationPage registrationPage = new AccountRegistrationPage();

    public AccountRegistrationPage fillInRegistrationForm(User user) {
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

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.typeTelephone(telephoneNumber);
        registrationPage.typeFax(faxNumber);
        registrationPage.typeCompany(company);
        registrationPage.typeFirstAddress(firstAddress);
        registrationPage.typeSecondAddress(secondAddress);
        registrationPage.typeCity(city);
        registrationPage.typePostcode(postCode);
        registrationPage.selectRegion(region);
        registrationPage.typePassword(password);
        registrationPage.typePasswordConfirm(password);
        return registrationPage;
    }

    public SuccessfulAccountRegistrationPage registerUser(User user) {
        fillInRegistrationForm(user);
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        registrationPage.clickContinueButton();
        return new SuccessfulAccountRegistrationPage();
    }
}
