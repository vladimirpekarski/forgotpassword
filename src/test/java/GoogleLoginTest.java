import basetest.BaseTest;
import org.testng.annotations.Test;
import pageobject.googlemail.GoogleLoginPage;

public class GoogleLoginTest extends BaseTest {
    //@TODO somehow change url to google.com
    @Test(enabled = false)
    public void loginGoogleTest() throws InterruptedException {
        GoogleLoginPage.loginGoogleMail("userName", "userPass");
    }
}
