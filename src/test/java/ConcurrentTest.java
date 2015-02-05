import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleEmailPage;
import pageobject.googlemail.GoogleEmailsListPage;
import pageobject.googlemail.GoogleHelpPage;
import pageobject.googlemail.GoogleLoginPage;
import pageobject.onliner.*;

import static helpers.Actions.openURl;
import static helpers.Actions.switchTab;
import static helpers.UserCred.getUser;
import static helpers.Waiters.waitForElementDisplay;
import static helpers.Waiters.waitForTitle;
import static steps.Steps.goLostPageOnlinerAndSendEmail;

public class ConcurrentTest extends BaseTest{
    private String onlinerUserName = getUser("onliner.user")[0];
    private String onlinerUserNewPass = getUser("onliner.user")[1];
    private String googleUserName = getUser("google.user")[0];
    private String googleUserPass = getUser("google.user")[1];

    @Test
    public void loginTest(){
        OnlinerMainPage.clickEnterButton();
        OnlinerLoginPage.login(onlinerUserName, onlinerUserNewPass);
        waitForElementDisplay(OnlinerInternalPage.EXIT_LINK_LOCATOR);

        Assert.assertTrue(OnlinerInternalPage.isLoggedIn());
    }

    @Test
    public void LogInGoogleTest() {
        openURl("https://www.gmail.com/intl/ru/mail/help/about.html");
        GoogleHelpPage.clickSignInLink();

        GoogleLoginPage.loginGoogleMail(googleUserName, googleUserPass);
        waitForTitle(googleUserName);
        Assert.assertTrue(GoogleEmailsListPage.isUserLoggedIn(googleUserName));

        openURl("http://mail.google.com/mail?ui=html");

        GoogleEmailsListPage.openOnlinerEmail();
        Assert.assertTrue(GoogleEmailPage.isRestoreEmail());

        GoogleEmailPage.openOnlinerChangePasswordPage();
        switchTab("Onliner");
        OnlinerChangePasswordPage.saveNewPassword(onlinerUserNewPass);
    }

    @Test
    public void forgotPasswordTest() {
        goLostPageOnlinerAndSendEmail(onlinerUserName);
        Assert.assertTrue(OnlinerConfirmPage.isConfirmPage());

        openURl("https://www.gmail.com/intl/ru/mail/help/about.html");
        GoogleHelpPage.clickSignInLink();

        Assert.assertTrue(GoogleLoginPage.isGoogleLoginPage());

        GoogleLoginPage.loginGoogleMail(googleUserName, googleUserPass);

        waitForTitle(googleUserName);
        Assert.assertTrue(GoogleEmailsListPage.isUserLoggedIn(googleUserName));

        openURl("http://mail.google.com/mail?ui=html");

        GoogleEmailsListPage.openOnlinerEmail();
        Assert.assertTrue(GoogleEmailPage.isRestoreEmail());

        GoogleEmailPage.openOnlinerChangePasswordPage();

        switchTab("Onliner");
        Assert.assertTrue(OnlinerChangePasswordPage.isOnlinerChangePasswordPage());

        OnlinerChangePasswordPage.saveNewPassword(onlinerUserNewPass);
        OnlinerLoginPage.login(onlinerUserName, onlinerUserNewPass);
        waitForElementDisplay(OnlinerInternalPage.EXIT_LINK_LOCATOR);

        Assert.assertTrue(OnlinerInternalPage.isLoggedIn());
    }
}
