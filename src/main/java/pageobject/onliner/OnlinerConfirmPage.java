package pageobject.onliner;

import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class OnlinerConfirmPage {
    public static final By CONFIRM_MESSAGE_LABEL = getLocator("onlinerConfirmPage.confirmLabel");

    public static Boolean isConfirmPage() {
        return getWebdriver().findElement(CONFIRM_MESSAGE_LABEL)
                .getText().equals("Спасибо! Инструкции высланы на адрес, указанный вами при регистрации");
    }
}
