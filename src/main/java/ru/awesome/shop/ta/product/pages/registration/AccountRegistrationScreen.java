package ru.awesome.shop.ta.product.pages.registration;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.*;

import static java.lang.String.format;

public class AccountRegistrationScreen {
    private final By firstNameBy = By.id("input-firstname");
    private final By lastNameBy = By.id("input-lastname");
    private final By emailBy = By.id("input-email");
    private final By telephoneBy = By.id("input-telephone");
    private final By faxBy = By.id("input-fax");
    private final By companyBy = By.id("input-company");
    private final By firstAddressBy = By.id("input-address-1");
    private final By secondAddressBy = By.id("input-address-2");
    private final By cityBy = By.id("input-city");
    private final By postcodeBy = By.id("input-postcode");
    private final By countryBy = By.id("input-country");
    private final By regionBy = By.id("input-zone");
    private final By passwordBy = By.id("input-password");
    private final By passwordConfirmBy = By.id("input-confirm");
    private final By subscribeYesBy = By.xpath("//label[@class='radio-inline']/input[@value='1']");
    private final By subscribeNoBy = By.xpath("//label[@class='radio-inline']/input[@value='0']");
    private final By privacyPolicyBy = By.xpath("//b[text()='Privacy Policy']/..");
    private final By agreeWithPrivacyPolicyBy = By.name("agree");
    private final By continueButtonBy = By.xpath("//input[@type='submit']");

    private String emptyFieldWarningLocator = "//div[text()='%s must be between 1 and 32 characters!']";

    public AccountRegistrationScreen firstNameType(String text) {
        TextField firstName = new TextField(firstNameBy);
        firstName.type(text);
        return this;
    }

    public AccountRegistrationScreen lastNameType(String text) {
        TextField lastName = new TextField(lastNameBy);
        lastName.type(text);
        return this;
    }

    public AccountRegistrationScreen emailType(String text) {
        TextField email = new TextField(emailBy);
        email.type(text);
        return this;
    }

    public AccountRegistrationScreen telephoneType(String text) {
        TextField telephone = new TextField(telephoneBy);
        telephone.type(text);
        return this;
    }

    public AccountRegistrationScreen faxType(String text) {
        TextField fax = new TextField(faxBy);
        fax.type(text);
        return this;
    }

    public AccountRegistrationScreen companyType(String text) {
        TextField company = new TextField(companyBy);
        company.type(text);
        return this;
    }

    public AccountRegistrationScreen firstAddressType(String text) {
        TextField firstAddress = new TextField(firstAddressBy);
        firstAddress.type(text);
        return this;
    }

    public AccountRegistrationScreen secondAddressType(String text) {
        TextField secondAddress = new TextField(secondAddressBy);
        secondAddress.type(text);
        return this;
    }

    public AccountRegistrationScreen cityType(String text) {
        TextField city = new TextField(cityBy);
        city.type(text);
        return this;
    }

    public AccountRegistrationScreen postcodeType(String text) {
        TextField postcode = new TextField(postcodeBy);
        postcode.type(text);
        return this;
    }

    public AccountRegistrationScreen countrySelect(String option) {
        DropDownList country = new DropDownList(countryBy);
        country.select(option);
        return this;
    }

    public AccountRegistrationScreen regionSelect(String option) {
        DropDownList region = new DropDownList(regionBy);
        region.select(option);
        return this;
    }

    public AccountRegistrationScreen passwordType(String text) {
        TextField password = new TextField(passwordBy);
        password.type(text);
        return this;
    }

    public AccountRegistrationScreen passwordConfirmType(String text) {
        TextField passwordConfirm = new TextField(passwordConfirmBy);
        passwordConfirm.type(text);
        return this;
    }

    public AccountRegistrationScreen subscribeYesClick(String text) {
        RadioButton subscribeYes = new RadioButton(subscribeYesBy);
        subscribeYes.click();
        return this;
    }

    public AccountRegistrationScreen subscribeNoClick(String text) {
        RadioButton subscribeNo = new RadioButton(subscribeNoBy);
        subscribeNo.click();
        return this;
    }

    public AccountRegistrationScreen privacyPolicyClick() {
        Link privacyPolicy = new Link(privacyPolicyBy);
        privacyPolicy.click();
        return this;
    }

    public AccountRegistrationScreen agreeWithPrivacyPolicyClick() {
        Checkbox agreeWithPrivacyPolicy = new Checkbox(agreeWithPrivacyPolicyBy);
        agreeWithPrivacyPolicy.setSelected(true);
        return this;
    }

    public AccountRegistrationSuccessfullyScreen continueButtonClick() {
        Button continueButton = new Button(continueButtonBy);
        continueButton.click();
        return new AccountRegistrationSuccessfullyScreen();
    }

    public String getFieldWarning(Field field) {
        String fieldLocator = format(emptyFieldWarningLocator, field.getName());
        By fieldBy = By.xpath(fieldLocator);
        Label warningLabel = new Label(fieldBy);
        return warningLabel.getText();
    }

    public enum Field {
        FIRST_NAME("First Name"), LAST_NAME("Last Name"), EMAIL("E-Mail"),
        TELEPHONE("Telephone"), FAX("Fax"), COMPANY("Company"),
        ADDRESS_1("Address 1"), ADDRESS_2("Address 2"), CITY("City"),
        POST_CODE("Post Code"), COUNTRY("Country"), REGION("Region / State"),
        PASSWORD("Password"), PASSWORD_CONFIRM("Password Confirm");

        private String name;

        Field(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
