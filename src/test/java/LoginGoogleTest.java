import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleEmailsPage;
import pageobject.googlemail.GoogleLoginPage;

import static helpers.Waiters.waitUntilScriptsEnd;

public class LoginGoogleTest extends BaseTest {
    @Test
    public void LogInGoogleTest() {
        GoogleLoginPage.getGooglePage();
        GoogleLoginPage.loginGoogleMail("emai", "pass");
        waitUntilScriptsEnd();
        Assert.assertTrue(GoogleEmailsPage.isGoogleEmailsPage());
    }
}
