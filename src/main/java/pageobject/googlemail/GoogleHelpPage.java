package pageobject.googlemail;


import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class GoogleHelpPage {
    public static final By SIGN_LINK_LABEL = getLocator("googleHelpPage.signInLink");

    public static void clickSignInLink() {
        getWebdriver().findElement(SIGN_LINK_LABEL).click();
    }
}
