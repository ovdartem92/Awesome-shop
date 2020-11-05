package service;

import pages.net.skyscanner.elements.HeaderScreen;

public class CultureService {

    public void changeLanguage(String language) {
        new HeaderScreen().clickRegionalSettingsButton()
                .clickLanguageSelectButton()
                .clickLanguageOptionButton(language)
                .clickCultureSaveButton();
    }

    public void changeCurrency(String currency) {
        new HeaderScreen().clickRegionalSettingsButton()
                .clickCurrencySelectButton()
                .clickCurrencyOptionButton(currency)
                .clickCultureSaveButton();
    }
}
