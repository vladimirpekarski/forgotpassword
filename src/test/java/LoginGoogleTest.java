import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleEmailsPage;
import pageobject.googlemail.GoogleLoginPage;

import static helpers.UserCred.getUser;
import static helpers.Waiters.waitForSpecificTilte;

public class LoginGoogleTest extends BaseTest {
    @Test
    public void LogInGoogleTest() {
        GoogleLoginPage.getGooglePage();
        GoogleLoginPage.loginGoogleMail(getUser("google.user")[0], getUser("google.user")[1]);
        waitForSpecificTilte(getUser("google.user")[0]);
        Assert.assertTrue(GoogleEmailsPage.isGoogleEmailsPage());
    }
}
