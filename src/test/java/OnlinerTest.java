import basetest.BaseTest;
import helpers.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleEmailsPage;
import pageobject.googlemail.GoogleLoginPage;
import pageobject.onliner.OnlinerConfirmPage;

import static helpers.UserCred.getUser;
import static helpers.Waiters.waitForSpecificTilte;
import static steps.Steps.goLostPageOnlinerAndSendEmail;

@Listeners(CustomListener.class)
public class OnlinerTest extends BaseTest {
    @Test
    public void confirmPageTest() throws InterruptedException {
        goLostPageOnlinerAndSendEmail(getUser("onliner.user")[0]);
        Assert.assertTrue(OnlinerConfirmPage.isConfirmPage());

        GoogleLoginPage.getGooglePage();

        Assert.assertTrue(GoogleLoginPage.isGoogleLoginPage());
        GoogleLoginPage.loginGoogleMail(getUser("google.user")[0], getUser("google.user")[1]);

        waitForSpecificTilte(getUser("google.user")[0]);
        Assert.assertTrue(GoogleEmailsPage.isGoogleEmailsPage());
    }
}
