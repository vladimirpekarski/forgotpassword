package pageobject.onliner;

import helpers.UserCred;
import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static helpers.UserCred.getUser;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class OnlinerLoginPage {
    public static final By FORGOT_LINK_LOCATOR =
            getLocator("onlinerLoginPage.forgotLink");
    public static final By USER_EMAIL_FIELD_LOCATOR =
            getLocator("onlinerLoginPage.userEmailField");
    public static final By USER_PASS_FIELD_LOCATOR =
            getLocator("onlinerLoginPage.userPassField");
    public static final By ENTER_BUTTON_LOCATOR =
            getLocator("onlinerLoginPage.enterButton");


    public static void clickForgotLink() {
        getWebdriver().findElement(FORGOT_LINK_LOCATOR).click();
    }

    public static void login(String userName, String userPass) {
        getWebdriver().findElement(USER_EMAIL_FIELD_LOCATOR).clear();
        getWebdriver().findElement(USER_EMAIL_FIELD_LOCATOR).sendKeys(userName);

        getWebdriver().findElement(USER_PASS_FIELD_LOCATOR).clear();
        getWebdriver().findElement(USER_PASS_FIELD_LOCATOR).sendKeys(userPass);

        getWebdriver().findElement(ENTER_BUTTON_LOCATOR).click();
    }
}
