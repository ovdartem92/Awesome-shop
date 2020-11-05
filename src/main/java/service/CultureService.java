package service;

import pages.net.skyscanner.elements.HeaderScreen;

public class CultureService {
    public HeaderScreen header = new HeaderScreen();

    public void changeLanguage(String language) {
        header.clickRegionalSettingsButton()
                .clickLanguageSelectButton()
                .clickLanguageOptionButton(language)
                .clickCultureSaveButton();
    }

    public void changeCurrency(String currency) {
        header.clickRegionalSettingsButton()
                .clickCurrencySelectButton()
                .clickCurrencyOptionButton(currency)
                .clickCultureSaveButton();
    }
}
