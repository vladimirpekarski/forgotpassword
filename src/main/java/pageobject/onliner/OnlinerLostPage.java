package pageobject.onliner;

import org.openqa.selenium.By;


import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class OnlinerLostPage {
    public static final By EMAIL_FIELD_LOCATOR = getLocator("onlinerLostPage.emailField");
    public static final By SEND_BUTTON_LOCATOR = getLocator("onlinerLostPage.sendButtom");

    public static void typeEmailAndSend(String email) {
        getWebdriver().findElement(EMAIL_FIELD_LOCATOR).clear();
        getWebdriver().findElement(EMAIL_FIELD_LOCATOR).sendKeys(email);
        getWebdriver().findElement(SEND_BUTTON_LOCATOR).click();
    }
}
