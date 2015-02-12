import testbase.TestBase;
import helpers.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleEmailPage;
import pageobject.googlemail.GoogleEmailsListPage;
import pageobject.googlemail.GoogleHelpPage;
import pageobject.googlemail.GoogleLoginPage;
import pageobject.onliner.OnlinerChangePasswordPage;
import pageobject.onliner.OnlinerConfirmPage;
import pageobject.onliner.OnlinerInternalPage;
import pageobject.onliner.OnlinerLoginPage;

import static helpers.Actions.*;
import static helpers.UserCred.getUser;
import static helpers.Waiters.waitForElementDisplayed;
import static helpers.Waiters.waitForTitleContains;
import static steps.Steps.openLostPageOnlinerAndSendEmail;

@Listeners(CustomListener.class)
public class OnlinerTest extends TestBase {
    private String googleUserName = getUser("google.user")[0];
    private String googleUserPass = getUser("google.user")[1];
    private String onlinerUserName = getUser("onliner.user")[0];
    private String onlinerUserNewPass = getUser("onliner.user")[1];

    @Test
    public void forgotPasswordTest() {
        openLostPageOnlinerAndSendEmail(onlinerUserName);
        Assert.assertTrue(OnlinerConfirmPage.isConfirmPage());

        openURl("https://www.gmail.com/intl/ru/mail/help/about.html");
        GoogleHelpPage.clickSignInLink();

        Assert.assertTrue(GoogleLoginPage.isGoogleLoginPage());

        GoogleLoginPage.loginGoogleMail(googleUserName, googleUserPass);

        waitForTitleContains(googleUserName);
        Assert.assertTrue(GoogleEmailsListPage.isUserLoggedIn(googleUserName));

        openURl("http://mail.google.com/mail?ui=html");

        GoogleEmailsListPage.openOnlinerEmail();
        Assert.assertTrue(GoogleEmailPage.isRestoreEmail("Восстановление пароля"));

        GoogleEmailPage.openOnlinerChangePasswordPage();

        switchTab("Onliner");
        Assert.assertTrue(OnlinerChangePasswordPage.isOnlinerChangePasswordPage());

        OnlinerChangePasswordPage.saveNewPassword(onlinerUserNewPass);
        OnlinerLoginPage.login(onlinerUserName, onlinerUserNewPass);
        waitForElementDisplayed(OnlinerInternalPage.EXIT_LINK_LOCATOR);

        Assert.assertTrue(OnlinerInternalPage.isLoggedIn());
    }
}
