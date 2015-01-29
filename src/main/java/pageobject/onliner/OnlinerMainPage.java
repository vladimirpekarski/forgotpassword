package pageobject.onliner;

import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class OnlinerMainPage {
    public static final By ENTER_BUTTON_LOCATOR = getLocator("onlinerMainPage.enterButton");

    public static void clickEnterButton() {
        getWebdriver().findElement(ENTER_BUTTON_LOCATOR).click();
    }
}
