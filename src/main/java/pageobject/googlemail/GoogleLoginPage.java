package pageobject.googlemail;

import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class GoogleLoginPage {
    public static final By EMAIL_FIEL_LOCATOR = getLocator("googleLoginPage.emailField");
    public static final By PASS_FIELD_LOCATOR = getLocator("googleLoginPage.passField");
    public static final By SIGN_IN_BUTTON_LOCATOR = getLocator("googleLoginPage.signInButton");
    public static final By SIGN_IN_LABEL = getLocator("googleLoginPage.signInLabel");

    public static void getGooglePage() {
        getWebdriver().get("https://mail.google.com/");
    }

    public static Boolean isGoogleLoginPage() {
        return getWebdriver().findElement(SIGN_IN_BUTTON_LOCATOR).isDisplayed();
    }

    public static void loginGoogleMail(String userName, String userPass) {
        getWebdriver().findElement(EMAIL_FIEL_LOCATOR).sendKeys(userName);
        getWebdriver().findElement(PASS_FIELD_LOCATOR).sendKeys(userPass);
        getWebdriver().findElement(SIGN_IN_BUTTON_LOCATOR).click();
    }

    public static void getGoogleBasicHTML() {
        getWebdriver().get("http://mail.google.com/mail?ui=html");
    }
}
