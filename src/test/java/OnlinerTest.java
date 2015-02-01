import basetest.BaseTest;
import helpers.Actions;
import helpers.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleEmailPage;
import pageobject.googlemail.GoogleEmailsListPage;
import pageobject.googlemail.GoogleLoginPage;
import pageobject.onliner.OnlinerChangePasswordPage;
import pageobject.onliner.OnlinerConfirmPage;
import pageobject.onliner.OnlinerLoginPage;

import static helpers.Actions.getGoogleBasicHTML;
import static helpers.Actions.getGooglePage;
import static helpers.Actions.switchTab;
import static helpers.UserCred.getUser;
import static helpers.Waiters.waitForSpecificTilte;
import static steps.Steps.goLostPageOnlinerAndSendEmail;

@Listeners(CustomListener.class)
public class OnlinerTest extends BaseTest {
    @Test
    public void confirmPageTest() throws InterruptedException {
        goLostPageOnlinerAndSendEmail(getUser("onliner.user")[0]);
        Assert.assertTrue(OnlinerConfirmPage.isConfirmPage());

        getGooglePage();
        Assert.assertTrue(GoogleLoginPage.isGoogleLoginPage());

        GoogleLoginPage.loginGoogleMail(getUser("google.user")[0], getUser("google.user")[1]);

        waitForSpecificTilte(getUser("google.user")[0]);
        Assert.assertTrue(GoogleEmailsListPage.isGoogleEmailsListPage());

        getGoogleBasicHTML();

        GoogleEmailsListPage.openOnlinerEmail();
        Assert.assertTrue(GoogleEmailPage.isRestoreEmail());

        GoogleEmailPage.openOnlinerChangePasswordPage();

        switchTab("Onliner");
        Assert.assertTrue(OnlinerChangePasswordPage.isOnlinerChangePasswordPage());

        OnlinerChangePasswordPage.saveNewPassword();

//        OnlinerLoginPage.
    }
}
