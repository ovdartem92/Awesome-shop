package ru.awesome.shop.ta.product.pages.registration;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.*;

public class AccountRegistrationPage {

    public AccountRegistrationPage typeFirstName(String firstName) {
        By firstNameLocator = By.id("input-firstname");
        TextField firstNameField = new TextField(firstNameLocator);
        firstNameField.type(firstName);
        return this;
    }

    public AccountRegistrationPage typeLastName(String lastName) {
        By lastNameLocator = By.id("input-lastname");
        TextField lastNameField = new TextField(lastNameLocator);
        lastNameField.type(lastName);
        return this;
    }

    public AccountRegistrationPage typeEmail(String emailAddress) {
        By emailLocator = By.id("input-email");
        TextField emailField = new TextField(emailLocator);
        emailField.type(emailAddress);
        return this;
    }

    public AccountRegistrationPage typeTelephone(String telephoneNumber) {
        By telephoneNumberLocator = By.id("input-telephone");
        TextField telephoneField = new TextField(telephoneNumberLocator);
        telephoneField.type(telephoneNumber);
        return this;
    }

    public AccountRegistrationPage typeFax(String faxNumber) {
        By faxNumberLocator = By.id("input-fax");
        TextField faxField = new TextField(faxNumberLocator);
        faxField.type(faxNumber);
        return this;
    }

    public AccountRegistrationPage typeCompany(String companyName) {
        By companyNameLocator = By.id("input-company");
        TextField companyField = new TextField(companyNameLocator);
        companyField.type(companyName);
        return this;
    }

    public AccountRegistrationPage typeFirstAddress(String firstAddress) {
        By firstAddressLocator = By.id("input-address-1");
        TextField firstAddressField = new TextField(firstAddressLocator);
        firstAddressField.type(firstAddress);
        return this;
    }

    public AccountRegistrationPage typeSecondAddress(String secondAddress) {
        By secondAddressLocator = By.id("input-address-2");
        TextField secondAddressField = new TextField(secondAddressLocator);
        secondAddressField.type(secondAddress);
        return this;
    }

    public AccountRegistrationPage typeCity(String city) {
        By cityLocator = By.id("input-city");
        TextField cityField = new TextField(cityLocator);
        cityField.type(city);
        return this;
    }

    public AccountRegistrationPage typePostcode(String postcode) {
        By postcodeLocator = By.id("input-postcode");
        TextField postcodeField = new TextField(postcodeLocator);
        postcodeField.type(postcode);
        return this;
    }

    public AccountRegistrationPage selectCountry(String country) {
        By countryLocator = By.id("input-country");
        DropDownList countryList = new DropDownList(countryLocator);
        countryList.select(country);
        return this;
    }

    public AccountRegistrationPage selectRegion(String region) {
        By regionLocator = By.id("input-zone");
        DropDownList regionList = new DropDownList(regionLocator);
        regionList.select(region);
        return this;
    }

    public AccountRegistrationPage typePassword(String password) {
        By passwordLocator = By.id("input-password");
        TextField passwordField = new TextField(passwordLocator);
        passwordField.type(password);
        return this;
    }

    public AccountRegistrationPage typePasswordConfirm(String passwordConfirm) {
        By passwordConfirmLocator = By.id("input-confirm");
        TextField passwordConfirmField = new TextField(passwordConfirmLocator);
        passwordConfirmField.type(passwordConfirm);
        return this;
    }

    public AccountRegistrationPage clickSubscribeYesButton() {
        By subscribeYesButtonLocator = By.xpath("//input[@name='newsletter'][@value='1']");
        RadioButton subscribeYesButton = new RadioButton(subscribeYesButtonLocator);
        subscribeYesButton.click();
        return this;
    }

    public AccountRegistrationPage clickSubscribeNoButton() {
        By subscribeNoButtonLocator = By.xpath("//input[@name='newsletter'][@value='0']");
        RadioButton subscribeNoButton = new RadioButton(subscribeNoButtonLocator);
        subscribeNoButton.click();
        return this;
    }

    public AccountRegistrationPage clickPrivacyPolicy() {
        By privacyPolicyLinkLocator = By.xpath("//b[text()='Privacy Policy']/..");
        Link privacyPolicyLink = new Link(privacyPolicyLinkLocator);
        privacyPolicyLink.click();
        return this;
    }

    public AccountRegistrationPage clickAgreeWithPrivacyPolicy() {
        By agreeWithPrivacyPolicyLocator = By.name("agree");
        Checkbox agreeWithPrivacyPolicyCheckbox = new Checkbox(agreeWithPrivacyPolicyLocator);
        agreeWithPrivacyPolicyCheckbox.setSelected(true);
        return this;
    }

    public AccountRegistrationSuccessfullyPage clickContinueButton() {
        By continueButtonLocator = By.xpath("//input[@value='Continue']");
        Button continueButton = new Button(continueButtonLocator);
        continueButton.click();
        return new AccountRegistrationSuccessfullyPage();
    }

    public String getDangerMessage() {
        By dangerLabelLocator = By.xpath("//div[contains(@class, 'alert-danger')]");
        Label dangerLabel = new Label(dangerLabelLocator);
        return dangerLabel.getText();
    }

    public String getPrivacyPolicyTitle() {
        By policyTitleLabelLocator = By.xpath("//h4[contains(text(),'Privacy Policy')]");
        Label policyTitleLabel = new Label(policyTitleLabelLocator);
        return policyTitleLabel.getText();
    }

    public String getFirstNameInvalidWarning() {
        By firstNameInvalidWarningLocator = By.xpath("//div[text()='First Name shouldn't contains" +
                " space character, special symbols, numerals.']");
        Label firstNameInvalidWarningLabel = new Label(firstNameInvalidWarningLocator);
        return firstNameInvalidWarningLabel.getText();
    }

    public String getLastNameInvalidWarning() {
        By lastNameInvalidWarningLocator = By.xpath("//div[text()='Last Name shouldn't contains" +
                " space character, special symbols, numerals.']");
        Label lastNameInvalidWarningLabel = new Label(lastNameInvalidWarningLocator);
        return lastNameInvalidWarningLabel.getText();
    }

    public String getTelephoneInvalidWarning() {
        By telephoneInvalidWarningLocator = By.xpath("//div[text()='Telephone shouldn't contains" +
                " space characters, special symbols expect +,-,(), #,*, alphabetic characters.']");
        Label telephoneInvalidWarningLabel = new Label(telephoneInvalidWarningLocator);
        return telephoneInvalidWarningLabel.getText();
    }

    public String getCityInvalidWarning() {
        By cityInvalidWarningLocator = By.xpath("//div[text()='City shouldn't contains" +
                " special symbols and numerals!']");
        Label cityInvalidWarningLabel = new Label(cityInvalidWarningLocator);
        return cityInvalidWarningLabel.getText();
    }

    public String getFirstNameLengthWarning() {
        By firstNameLengthWarningLocator = By.xpath("//div[text()='First Name must be between 1 and 32 characters!']");
        Label firstNameLengthWarningLabel = new Label(firstNameLengthWarningLocator);
        return firstNameLengthWarningLabel.getText();
    }

    public String getLastNameLengthWarning() {
        By lastNameLengthWarningLocator = By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']");
        Label lastNameLengthWarningLabel = new Label(lastNameLengthWarningLocator);
        return lastNameLengthWarningLabel.getText();
    }

    public String getEmailLengthWarning() {
        By emailLengthWarningLocator = By.xpath("//div[text()='E-Mail Address does not appear to be valid!']");
        Label emailLengthWarningLabel = new Label(emailLengthWarningLocator);
        return emailLengthWarningLabel.getText();
    }

    public String getTelephoneNumberLengthWarning() {
        By telephoneNumberLengthWarningLocator = By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']");
        Label telephoneNumberLengthWarningLabel = new Label(telephoneNumberLengthWarningLocator);
        return telephoneNumberLengthWarningLabel.getText();
    }

    public String getFirstAddressLengthWarning() {
        By firstAddressLengthWarningLocator = By.xpath("//div[text()='Address 1 must be between 3 and 128 characters!']");
        Label firstAddressNumberLengthWarningLabel = new Label(firstAddressLengthWarningLocator);
        return firstAddressNumberLengthWarningLabel.getText();
    }

    public String getSecondAddressLengthWarning() {
        By secondAddressLengthWarningLocator = By.xpath("//div[text()='Address 2 must be between 3 and 128 characters!']");
        Label secondAddressNumberLengthWarningLabel = new Label(secondAddressLengthWarningLocator);
        return secondAddressNumberLengthWarningLabel.getText();
    }

    public String getCityLengthWarning() {
        By cityLengthWarningLocator = By.xpath("//div[text()='City must be between 2 and 128 characters!']");
        Label cityLengthWarningLabel = new Label(cityLengthWarningLocator);
        return cityLengthWarningLabel.getText();
    }

    public String getPostCodeLengthWarning() {
        By postCodeLengthWarningLocator = By.xpath("//div[text()='Postcode must be between 2 and 10 characters!']");
        Label postCodeLengthWarningLabel = new Label(postCodeLengthWarningLocator);
        return postCodeLengthWarningLabel.getText();
    }

    public String getRegionLengthWarning() {
        By regionLengthWarningLocator = By.xpath("//div[text()='Please select a region / state!']");
        Label regionLengthWarningLabel = new Label(regionLengthWarningLocator);
        return regionLengthWarningLabel.getText();
    }

    public String getPasswordLengthWarning() {
        By passwordLengthWarningLocator = By.xpath("//div[text()='Password must be between 4 and 20 characters!']");
        Label passwordLengthWarningLabel = new Label(passwordLengthWarningLocator);
        return passwordLengthWarningLabel.getText();
    }

    public String getPasswordConfirmLengthWarning() {
        By passwordConfirmLengthWarningLocator = By.xpath("//div[text()='Password confirmation does not match password!']");
        Label passwordConfirmLengthWarningLabel = new Label(passwordConfirmLengthWarningLocator);
        return passwordConfirmLengthWarningLabel.getText();
    }
}
