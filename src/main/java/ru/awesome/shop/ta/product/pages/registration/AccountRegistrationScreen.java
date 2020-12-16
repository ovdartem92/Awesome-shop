package ru.awesome.shop.ta.product.pages.registration;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.*;

public class AccountRegistrationScreen {
    private TextField firstNameField = new TextField(By.id("input-firstname"));
    private TextField lastNameField = new TextField(By.id("input-lastname"));
    private TextField emailField = new TextField(By.id("input-email"));
    private TextField telephoneField = new TextField(By.id("input-telephone"));
    private TextField faxField = new TextField(By.id("input-fax"));
    private TextField companyField = new TextField(By.id("input-company"));
    private TextField firstAddressField = new TextField(By.id("input-address-1"));
    private TextField secondAddressField = new TextField(By.id("input-address-2"));
    private TextField cityField = new TextField(By.id("input-city"));
    private TextField postcodeField = new TextField(By.id("input-postcode"));
    private DropDownList countryList = new DropDownList(By.id("input-country"));
    private DropDownList regionList = new DropDownList(By.id("input-zone"));
    private TextField passwordField = new TextField(By.id("input-password"));
    private TextField passwordConfirmField = new TextField(By.id("input-confirm"));
    private RadioButton subscribeYesRadio = new RadioButton(By.xpath("//input[@name='newsletter'][@value='1']"));
    private RadioButton subscribeNoRadio = new RadioButton(By.xpath("//input[@name='newsletter'][@value='0']"));
    private Link privacyPolicyLink = new Link(By.xpath("//b[text()='Privacy Policy']/.."));
    private Checkbox agreeWithPrivacyPolicyCheckbox = new Checkbox(By.name("agree"));
    private Button continueButton = new Button(By.xpath("//input[@type='submit']"));
    private Label dangerAlertLabel = new Label(By.xpath("//div[contains(@class, 'alert-danger')]"));
    private Label policyTitleLabel = new Label(By.xpath("//h4[contains(text(),'Privacy Policy')]"));

    public AccountRegistrationScreen firstNameType(String text) {
        firstNameField.type(text);
        return this;
    }

    public AccountRegistrationScreen lastNameType(String text) {
        lastNameField.type(text);
        return this;
    }

    public AccountRegistrationScreen emailType(String text) {
        emailField.type(text);
        return this;
    }

    public AccountRegistrationScreen telephoneType(String text) {
        telephoneField.type(text);
        return this;
    }

    public AccountRegistrationScreen faxType(String text) {
        faxField.type(text);
        return this;
    }

    public AccountRegistrationScreen companyType(String text) {
        companyField.type(text);
        return this;
    }

    public AccountRegistrationScreen firstAddressType(String text) {
        firstAddressField.type(text);
        return this;
    }

    public AccountRegistrationScreen secondAddressType(String text) {
        secondAddressField.type(text);
        return this;
    }

    public AccountRegistrationScreen cityType(String text) {
        cityField.type(text);
        return this;
    }

    public AccountRegistrationScreen postcodeType(String text) {
        postcodeField.type(text);
        return this;
    }

    public AccountRegistrationScreen countrySelect(String option) {
        countryList.select(option);
        return this;
    }

    public AccountRegistrationScreen regionSelect(String option) {
        regionList.select(option);
        return this;
    }

    public AccountRegistrationScreen passwordType(String text) {
        passwordField.type(text);
        return this;
    }

    public AccountRegistrationScreen passwordConfirmType(String text) {
        passwordConfirmField.type(text);
        return this;
    }

    public AccountRegistrationScreen subscribeYesClick(String text) {
        subscribeYesRadio.click();
        return this;
    }

    public AccountRegistrationScreen subscribeNoClick(String text) {
        subscribeNoRadio.click();
        return this;
    }

    public AccountRegistrationScreen privacyPolicyClick() {
        privacyPolicyLink.click();
        return this;
    }

    public AccountRegistrationScreen agreeWithPrivacyPolicyClick() {
        agreeWithPrivacyPolicyCheckbox.setSelected(true);
        return this;
    }

    public AccountRegistrationSuccessfullyScreen continueButtonClick() {
        continueButton.click();
        return new AccountRegistrationSuccessfullyScreen();
    }

    public String getDangerAlertMessage() {
        return dangerAlertLabel.getText();
    }

    public boolean isDisplayedPrivacyPolicyWindow() {
        String title = policyTitleLabel.getText();
        return title.equals("Privacy Policy");
    }

    public Boolean isFieldInvalidWarning(Field field) {
        String fieldLocator;
        switch (field) {
            case FIRST_NAME:
                fieldLocator = "//div[text()='First Name shouldn't contains space character," +
                        " special symbols, numerals.']";
                break;
            case LAST_NAME:
                fieldLocator = "//div[text()='Last Name shouldn't contains space character," +
                        " special symbols, numerals.']";
                break;
            case TELEPHONE:
                fieldLocator = "//div[text()='Telephone shouldn't contains space characters, special symbols" +
                        " expect +,-,(), #,*, alphabetic characters.']";
                break;
            case CITY:
                fieldLocator = "//div[text()='City shouldn't contains special symbols and numerals!']";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
        By fieldBy = By.xpath(fieldLocator);
        Label warningLabel = new Label(fieldBy);
        return warningLabel.isDisplayed();
    }

    public Boolean isFieldLengthWarning(Field field) {
        String fieldLocator;
        switch (field) {
            case FIRST_NAME:
                fieldLocator = "//div[text()='First Name must be between 1 and 32 characters!']";
                break;
            case LAST_NAME:
                fieldLocator = "//div[text()='Last Name must be between 1 and 32 characters!']";
                break;
            case EMAIL:
                fieldLocator = "//div[text()='E-Mail Address does not appear to be valid!']";
                break;
            case TELEPHONE:
                fieldLocator = "//div[text()='Telephone must be between 3 and 32 characters!']";
                break;
            case ADDRESS_1:
                fieldLocator = "//div[text()='Address 1 must be between 3 and 128 characters!']";
                break;
            case ADDRESS_2:
                fieldLocator = "//div[text()='Address 2 must be between 3 and 128 characters!']";
                break;
            case CITY:
                fieldLocator = "//div[text()='City must be between 2 and 128 characters!']";
                break;
            case POST_CODE:
                fieldLocator = "//div[text()='Postcode must be between 2 and 10 characters!']";
                break;
            case REGION:
                fieldLocator = "//div[text()='Please select a region / state!']";
                break;
            case PASSWORD:
                fieldLocator = "//div[text()='Password must be between 4 and 20 characters!']";
                break;
            case PASSWORD_CONFIRM:
                fieldLocator = "//div[text()='Password confirmation does not match password!']";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
        By fieldBy = By.xpath(fieldLocator);
        Label warningLabel = new Label(fieldBy);
        return warningLabel.isDisplayed();
    }

    public enum Field {
        FIRST_NAME, LAST_NAME, EMAIL,
        TELEPHONE, FAX, COMPANY,
        ADDRESS_1, ADDRESS_2, CITY,
        POST_CODE, COUNTRY, REGION,
        PASSWORD, PASSWORD_CONFIRM;
    }
}
