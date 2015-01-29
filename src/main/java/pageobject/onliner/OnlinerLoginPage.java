package pageobject.onliner;

import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class OnlinerLoginPage {
    public static final By FORGOT_LINK_LOCATOR = getLocator("onlinerLoginPage.forgotLink");

    public static void clickForgotLink() {
        getWebdriver().findElement(FORGOT_LINK_LOCATOR).click();
    }
}
