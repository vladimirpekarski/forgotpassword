package pageobject.onliner;

import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class OnlinerInternalPage {
    public static final By EXIT_LINK_LOCATOR =
            getLocator("onlinerInternalPage.exitLink");

    public static Boolean isLoggedIn() {
        return getWebdriver().findElement(EXIT_LINK_LOCATOR).isDisplayed();
    }
}
