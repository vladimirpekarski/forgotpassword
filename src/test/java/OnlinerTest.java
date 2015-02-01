import basetest.BaseTest;
import helpers.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleEmailsPage;
import pageobject.googlemail.GoogleLoginPage;
import pageobject.onliner.OnlinerConfirmPage;

import static helpers.Waiters.waitUntilScriptsEnd;
import static steps.Steps.goLostPageOnlinerAndSendEmail;

@Listeners(CustomListener.class)
public class OnlinerTest extends BaseTest {
    @Test
    public void confirmPageTest() throws InterruptedException {
        goLostPageOnlinerAndSendEmail("email");
        Assert.assertTrue(OnlinerConfirmPage.isConfirmPage());

        GoogleLoginPage.getGooglePage();

        Assert.assertTrue(GoogleLoginPage.isGoogleLoginPage());
        GoogleLoginPage.loginGoogleMail("user", "pass");

        waitUntilScriptsEnd();
        Assert.assertTrue(GoogleEmailsPage.isGoogleEmailsPage());
    }
}
