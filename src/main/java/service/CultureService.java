package service;

import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.elements.RegionalSettingsScreen;

public class CultureService {
    public static final HeaderScreen HEADER_SCREEN = new HeaderScreen();

    public static void changeLanguage(String language) {
        HEADER_SCREEN.clickRegionalSettingsButton();
        new RegionalSettingsScreen()
                .clickLanguageSelectButton()
                .clickLanguageOptionButton(language)
                .clickCultureSaveButton();
    }

    public static void changeCurrency(String currency) {
        new RegionalSettingsScreen()
                .clickCurrencySelectButton()
                .clickCurrencyOptionButton(currency)
                .clickCultureSaveButton();
    }
}
