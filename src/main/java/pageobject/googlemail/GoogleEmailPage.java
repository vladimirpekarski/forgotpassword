package pageobject.googlemail;

import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class GoogleEmailPage {
    public static final By ONLINER_URL_LOCATOR = getLocator("googleEmailPage.onlinerURL");

    public static Boolean isRestoreEmail() {
        return getWebdriver().getTitle().contains("Восстановление пароля"); // no hard code
    }

    public static void openOnlinerChangePasswordPage() {
        getWebdriver().findElement(ONLINER_URL_LOCATOR).click();
    }
}
