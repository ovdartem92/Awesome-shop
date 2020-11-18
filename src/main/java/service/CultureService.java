package service;

import pages.net.skyscanner.elements.HeaderScreen;

public class CultureService {
    private final HeaderScreen headerScreen = new HeaderScreen();

    public void changeLanguage(String language) {
        headerScreen.clickRegionalSettingsButton()
                .clickLanguageSelectButton()
                .clickLanguageOptionButton(language)
                .clickCultureSaveButton();
    }

    public void changeCurrency(String currency) {
        headerScreen.clickRegionalSettingsButton()
                .clickCurrencySelectButton()
                .clickCurrencyOptionButton(currency)
                .clickCultureSaveButton();
    }
}
