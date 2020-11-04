package service;

import pages.net.skyscanner.elements.RegionalSettingsScreen;

public class CultureService {

    public void changeLanguage(String language) {
        new RegionalSettingsScreen()
                .clickLanguageSelectButton()
                .clickLanguageOptionButton(language)
                .clickCultureSaveButton();
    }

    public void changeCurrency(String currency) {
        new RegionalSettingsScreen()
                .clickCurrencySelectButton()
                .clickCurrencyOptionButton(currency)
                .clickCultureSaveButton();
    }
}
