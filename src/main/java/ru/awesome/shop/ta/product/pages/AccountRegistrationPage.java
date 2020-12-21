package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.*;

public class AccountRegistrationPage extends BasePage {
    private static final String REGISTRATION_PAGE_URL = "index.php?route=account/register";

    public AccountRegistrationPage typeFirstName(String firstName) {
        By firstNameLocator = By.id("input-firstname");
        TextField firstNameTextField = new TextField(firstNameLocator);
        firstNameTextField.type(firstName);
        return this;
    }

    public AccountRegistrationPage typeLastName(String lastName) {
        By lastNameLocator = By.id("input-lastname");
        TextField lastNameTextField = new TextField(lastNameLocator);
        lastNameTextField.type(lastName);
        return this;
    }

    public AccountRegistrationPage typeEmail(String emailAddress) {
        By emailLocator = By.id("input-email");
        TextField emailTextField = new TextField(emailLocator);
        emailTextField.type(emailAddress);
        return this;
    }

    public AccountRegistrationPage typeTelephone(String telephoneNumber) {
        By telephoneNumberLocator = By.id("input-telephone");
        TextField telephoneTextField = new TextField(telephoneNumberLocator);
        telephoneTextField.type(telephoneNumber);
        return this;
    }

    public AccountRegistrationPage typeFax(String faxNumber) {
        By faxNumberLocator = By.id("input-fax");
        TextField faxTextField = new TextField(faxNumberLocator);
        faxTextField.type(faxNumber);
        return this;
    }

    public AccountRegistrationPage typeCompany(String companyName) {
        By companyNameLocator = By.id("input-company");
        TextField companyTextField = new TextField(companyNameLocator);
        companyTextField.type(companyName);
        return this;
    }

    public AccountRegistrationPage typeFirstAddress(String firstAddress) {
        By firstAddressLocator = By.id("input-address-1");
        TextField firstAddressTextField = new TextField(firstAddressLocator);
        firstAddressTextField.type(firstAddress);
        return this;
    }

    public AccountRegistrationPage typeSecondAddress(String secondAddress) {
        By secondAddressLocator = By.id("input-address-2");
        TextField secondAddressTextField = new TextField(secondAddressLocator);
        secondAddressTextField.type(secondAddress);
        return this;
    }

    public AccountRegistrationPage typeCity(String city) {
        By cityLocator = By.id("input-city");
        TextField cityTextField = new TextField(cityLocator);
        cityTextField.type(city);
        return this;
    }

    public AccountRegistrationPage typePostcode(String postcode) {
        By postcodeLocator = By.id("input-postcode");
        TextField postcodeTextField = new TextField(postcodeLocator);
        postcodeTextField.type(postcode);
        return this;
    }

    public AccountRegistrationPage selectCountry(String country) {
        By countryLocator = By.id("input-country");
        DropDownList countryDropDownList = new DropDownList(countryLocator);
        countryDropDownList.select(country);
        return this;
    }

    public AccountRegistrationPage selectRegion(String region) {
        By regionLocator = By.id("input-zone");
        DropDownList regionDropDownList = new DropDownList(regionLocator);
        regionDropDownList.select(region);
        return this;
    }

    public AccountRegistrationPage typePassword(String password) {
        By passwordLocator = By.id("input-password");
        TextField passwordTextField = new TextField(passwordLocator);
        passwordTextField.type(password);
        return this;
    }

    public AccountRegistrationPage typePasswordConfirm(String passwordConfirm) {
        By passwordConfirmLocator = By.id("input-confirm");
        TextField passwordConfirmTextField = new TextField(passwordConfirmLocator);
        passwordConfirmTextField.type(passwordConfirm);
        return this;
    }

    public AccountRegistrationPage clickSubscribeYesRadioButton() {
        By subscribeYesRadioButtonLocator = By.xpath("//input[@name='newsletter'][@value='1']");
        RadioButton subscribeYesRadioButton = new RadioButton(subscribeYesRadioButtonLocator);
        subscribeYesRadioButton.click();
        return this;
    }

    public AccountRegistrationPage clickSubscribeNoRadioButton() {
        By subscribeNoRadioButtonLocator = By.xpath("//input[@name='newsletter'][@value='0']");
        RadioButton subscribeNoRadioButton = new RadioButton(subscribeNoRadioButtonLocator);
        subscribeNoRadioButton.click();
        return this;
    }

    public AccountRegistrationPage clickPrivacyPolicyLink() {
        By privacyPolicyLinkLocator = By.xpath("//b[text()='Privacy Policy']/..");
        Link privacyPolicyLink = new Link(privacyPolicyLinkLocator);
        privacyPolicyLink.click();
        return this;
    }

    public AccountRegistrationPage clickAgreeWithPrivacyPolicyCheckbox() {
        By agreeWithPrivacyPolicyLocator = By.name("agree");
        Checkbox agreeWithPrivacyPolicyCheckbox = new Checkbox(agreeWithPrivacyPolicyLocator);
        agreeWithPrivacyPolicyCheckbox.setSelected(true);
        return this;
    }

    public SuccessfulAccountRegistrationPage clickContinueButton() {
        By continueButtonLocator = By.xpath("//input[@value='Continue']");
        Button continueButton = new Button(continueButtonLocator);
        continueButton.click();
        return new SuccessfulAccountRegistrationPage();
    }

    public String getWarningMessage() {
        By warningMessageLocator = By.xpath("//div[@class='text-danger']");
        Label warningMessageLabel = new Label(warningMessageLocator);
        return warningMessageLabel.getText();
    }

    public String getDangerMessage() {
        By dangerLabelLocator = By.xpath("//div[contains(@class, 'alert-danger')]");
        Label dangerLabel = new Label(dangerLabelLocator);
        return dangerLabel.getText();
    }

    public String getPrivacyPolicyTitle() {
        By policyTitle = By.xpath("//h4[contains(text(),'Privacy Policy')]");
        Label policyLabel = new Label(policyTitle);
        return policyLabel.getText();
    }

    @Override
    public void open() {
        Browser.getInstance().navigate(BASE_URL.concat(REGISTRATION_PAGE_URL));
    }
}
