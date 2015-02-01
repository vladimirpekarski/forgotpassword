package pageobject.onliner;

import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class OnlinerChangePasswordPage {
    public static final By CHANGE_PASSWORD_LABEL =
            getLocator("onlinerChangePasswordPage.changePasswordLabel");

    public static Boolean isOnlinerChangePasswordPage() {
        return getWebdriver().findElement(CHANGE_PASSWORD_LABEL).getText()
                .contains("Смена пароля");
    }
}
