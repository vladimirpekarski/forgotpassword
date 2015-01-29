package pageobject.googlemail;

import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class GoogleLoginPage {
    public static final By EMAIL_FIEL_LOCATOR = getLocator("googleLoginPage.emailField");
    public static final By PASS_FIELD_LOCATOR = getLocator("googleLoginPage.passField");
    public static final By SIGN_IN_BUTTON_LOCATOR = getLocator("googleLoginPage.signInButton");

    public static void loginGoogleMail(String userName, String userPass) {
        getWebdriver().findElement(EMAIL_FIEL_LOCATOR).clear();
        getWebdriver().findElement(EMAIL_FIEL_LOCATOR).sendKeys(userName);

        getWebdriver().findElement(PASS_FIELD_LOCATOR).clear();
        getWebdriver().findElement(PASS_FIELD_LOCATOR).sendKeys(userPass);

        getWebdriver().findElement(SIGN_IN_BUTTON_LOCATOR).click();
    }
}
