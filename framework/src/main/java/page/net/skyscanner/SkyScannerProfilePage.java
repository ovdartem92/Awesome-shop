package page.net.skyscanner;

import model.User;
import page.AbstractPage;

import static service.ActionManager.*;

public class SkyScannerProfilePage extends AbstractPage {
    private static final String ACCOUNT_FIELD_PATH = "//span[contains(text(), 'Account')]";
    private static final String LANGUAGE_PATH = "//li[@id='culture-info']//div/span";
    private static final String LANGUAGES_SELECT_PATH = "//select[@name='locale']";
    private static final String ENGLISH_LANGUAGE_OPTION_PATH = "//select[@name='locale']//option[@value='en-US']";
    private static final String CULTURE_SAVE_BUTTON_PATH = "//button[@id='culture-selector-save']";
    private static final String LOG_OUT_BUTTON_PATH = "//button[contains(text(), 'Log out')]";
    private static final String SECOND_LOG_OUT_BUTTON_PATH = "//*[@id='delete-dialog']/div/button[2]";

    public SkyScannerProfilePage clickOnAccountField() {
        clickOnElementBy(ACCOUNT_FIELD_PATH);
        return this;
    }

    public SkyScannerProfilePage switchToEnglish() {
        String language = getTextOnElementBy(LANGUAGE_PATH);

        if (!language.equals("English (UK)")) {
            clickOnElementBy(LANGUAGE_PATH);
            clickOnElementBy(LANGUAGES_SELECT_PATH);
            clickOnElementBy(ENGLISH_LANGUAGE_OPTION_PATH);
            clickOnElementBy(CULTURE_SAVE_BUTTON_PATH);
        }
        return this;
    }

    public SkyScannerHomePage logOut() {
        clickOnElementBy(LOG_OUT_BUTTON_PATH);
        clickOnElementBy(SECOND_LOG_OUT_BUTTON_PATH);
        return new SkyScannerHomePage();
    }

    public String getUserEmail(User user) {
        return getElementBy(String.format(ACCOUNT_FIELD_PATH, user.getEmail())).toString();
    }
}
