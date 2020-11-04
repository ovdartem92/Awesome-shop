package pages.net.skyscanner.elements;

import pages.AbstractPage;

public class RegionalSettingsScreen extends AbstractPage {
    private static final String CURRENCY_SELECT_LOCATOR = "//select[@id='culture-selector-currency']";
    private static final String LANGUAGES_SELECT_LOCATOR = "//select[@name='locale']";
    private static final String LANGUAGE_OPTION_LOCATOR = String.format("//select[@name='locale']//option[@value='%s']", "language");
    private static final String CURRENCY_OPTION_LOCATOR = String.format("//option[contains(text(), '%s')]", "currency");
    private static final String CULTURE_SAVE_BUTTON_LOCATOR = "//button[@id='culture-selector-save']";

    public RegionalSettingsScreen clickLanguageSelectButton() {
        clickOnElement(LANGUAGES_SELECT_LOCATOR);
        return this;
    }

    public RegionalSettingsScreen clickLanguageOptionButton(String language) {
        clickOnElement(LANGUAGE_OPTION_LOCATOR.replace("language", language));
        return this;
    }

    public HeaderScreen clickCultureSaveButton() {
        clickOnElement(CULTURE_SAVE_BUTTON_LOCATOR);
        return new HeaderScreen();
    }

    public RegionalSettingsScreen clickCurrencySelectButton() {
        clickOnElement(CURRENCY_SELECT_LOCATOR);
        return this;
    }

    public RegionalSettingsScreen clickCurrencyOptionButton(String currency) {
        clickOnElement(CURRENCY_OPTION_LOCATOR.replace("currency", currency));
        return this;
    }
}
