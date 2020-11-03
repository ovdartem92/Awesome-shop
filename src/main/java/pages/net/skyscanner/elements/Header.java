package pages.net.skyscanner.elements;

import pages.AbstractPage;

public class Header extends AbstractPage {
    private static final String CULTURE_SETTING_BUTTON = "//li[@id='culture-info']//button";
    private static final String CURRENCY_SELECT = "//select[@id='culture-selector-currency']";
    private static final String LANGUAGE_PATH = "//li[@id='culture-info']//div/span";
    private static final String LANGUAGES_SELECT_PATH = "//select[@name='locale']";
    private static final String LANGUAGE_OPTION_PATH = String.format("//select[@name='locale']//option[@value='%s']", "language");
    private static final String CURRENCY_OPTION_PATH = String.format("//option[contains(text(), '%s')]", "currency");
    private static final String HOTEL_TAB_PATH = "//nav[@id='PrimaryNav']//span[contains(text(), 'Hotels')]";
    private static final String CAR_HIRE_TAB_PATH = "//a[@id='carhi']";
    private static final String FLIGHTS_TAB_PATH = "//nav[@id='PrimaryNav']//span[contains(text(), 'Flights')]";
    private static final String CULTURE_SAVE_BUTTON_PATH = "//button[@id='culture-selector-save']";

    public Header changeLanguage(String language) {
        clickOnElement(CULTURE_SETTING_BUTTON);
        clickOnElement(LANGUAGES_SELECT_PATH);
        String languagePath = LANGUAGE_OPTION_PATH.replace("language", language);
        clickOnElement(languagePath);
        clickOnElement(CULTURE_SAVE_BUTTON_PATH);
        return this;
    }

    public Header changeCurrency(String currency) {
        clickOnElement(CULTURE_SETTING_BUTTON);
        clickOnElement(CURRENCY_SELECT);
        String newCurrency = CURRENCY_OPTION_PATH.replace("currency", currency);
        clickOnElement(newCurrency);
        clickOnElement(CULTURE_SAVE_BUTTON_PATH);
        return this;
    }
}
