package pageobject.onliner;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static helpers.Locators.getLocator;
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

    public static void saveNewPassword(String newPass) {
        Actions actionTypeNewPass = new Actions(getWebdriver());
        actionTypeNewPass.moveToElement(getWebdriver().findElement(PASSWORD_FILED_ONE_LABEL));
        actionTypeNewPass.click();
        actionTypeNewPass.sendKeys(newPass);
        actionTypeNewPass.build().perform();

        Actions actionConfirmNewPass = new Actions(getWebdriver());
        actionConfirmNewPass.moveToElement(getWebdriver().findElement(PASSWORD_FILED_TWO_LABEL));
        actionConfirmNewPass.click();
        actionConfirmNewPass.sendKeys(newPass);
        actionConfirmNewPass.build().perform();

        Actions actionClickSaveButton = new Actions(getWebdriver());
        actionClickSaveButton.moveToElement(getWebdriver().findElement(SAVE_BUTTON_LABEL));
        actionClickSaveButton.click();
        actionClickSaveButton.build().perform();
    }
}
