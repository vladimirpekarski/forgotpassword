package pageobject.onliner;
import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static helpers.UserCred.getUser;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class OnlinerChangePasswordPage {
    public static final By CHANGE_PASSWORD_LABEL =
            getLocator("onlinerChangePasswordPage.changePasswordLabel");
    public static final By PASSWORD_FILED_ONE_LABEL =
            getLocator("onlinerChangePasswordPage.passwordFieldOne");
    public static final By PASSWORD_FILED_TWO_LABEL =
            getLocator("onlinerChangePasswordPage.passwordFieldTwo");
    public static final By SAVE_BUTTON_LABEL =
            getLocator("onlinerChangePasswordPage.saveButton");

    public static Boolean isOnlinerChangePasswordPage() {
        return getWebdriver().findElement(CHANGE_PASSWORD_LABEL).getText()
                .contains("Смена пароля");
    }

    public static void saveNewPassword() {
        getWebdriver().findElement(PASSWORD_FILED_ONE_LABEL)
                .sendKeys(getUser("onliner.user")[1]);
        getWebdriver().findElement(PASSWORD_FILED_TWO_LABEL)
                .sendKeys(getUser("onliner.user")[1]);
        getWebdriver().findElement(SAVE_BUTTON_LABEL).click();
    }
}
