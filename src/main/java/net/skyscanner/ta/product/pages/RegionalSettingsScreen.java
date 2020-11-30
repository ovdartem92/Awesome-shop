package net.skyscanner.ta.product.pages;

import pages.AbstractScreen;

public class RegionalSettingsScreen extends AbstractScreen {
    private static final String CURRENCY_SELECT_LOCATOR = "//select[@id='culture-selector-currency']";
    private static final String LANGUAGES_SELECT_LOCATOR = "//select[@name='locale']";
    private static final String LANGUAGE_OPTION_LOCATOR = "//option[@value='%s']";
    private static final String CURRENCY_OPTION_LOCATOR = "//option[contains(text(), '%s')]";
    private static final String CULTURE_SAVE_BUTTON_LOCATOR = "//button[@id='culture-selector-save']";

    public RegionalSettingsScreen clickLanguageSelectButton() {
        clickOnElement(LANGUAGES_SELECT_LOCATOR);
        return this;
    }

    public RegionalSettingsScreen clickLanguageOptionButton(String language) {
        clickOnElement(String.format(LANGUAGE_OPTION_LOCATOR, language));
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
        clickOnElement(String.format(CURRENCY_OPTION_LOCATOR, currency));
        return this;
    }
}
