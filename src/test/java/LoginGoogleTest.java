import basetest.BaseTest;
import helpers.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleEmailPage;
import pageobject.googlemail.GoogleEmailsListPage;
import pageobject.googlemail.GoogleHelpPage;
import pageobject.googlemail.GoogleLoginPage;
import pageobject.onliner.OnlinerChangePasswordPage;

import static helpers.Actions.*;
import static helpers.UserCred.getUser;
import static helpers.Waiters.waitForTitle;

@Listeners(CustomListener.class)
public class LoginGoogleTest extends BaseTest {
    private String googleUserName = getUser("google.user")[0];
    private String googleUserPass = getUser("google.user")[1];
    private String onlinerUserNewPass = getUser("onliner.user")[1];

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
}
