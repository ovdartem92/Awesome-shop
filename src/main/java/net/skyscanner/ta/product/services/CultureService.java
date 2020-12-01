package net.skyscanner.ta.product.services;

import pages.net.skyscanner.elements.HeaderScreen;

/**
 * The service class helps to set language and currency value.
 */
public class CultureService {
    private final HeaderScreen headerScreen = new HeaderScreen();

    /**
     * This method performs actions for change language.
     *
     * @param language is necessary for pick language value
     */
    public void changeLanguage(String language) {
        headerScreen.clickRegionalSettingsButton()
                .clickLanguageSelectButton()
                .clickLanguageOptionButton(language)
                .clickCultureSaveButton();
    }

    /**
     * This method performs actions for change currency.
     *
     * @param currency is necessary for pick currency value
     */
    public void changeCurrency(String currency) {
        headerScreen.clickRegionalSettingsButton()
                .clickCurrencySelectButton()
                .clickCurrencyOptionButton(currency)
                .clickCultureSaveButton();
    }
}
