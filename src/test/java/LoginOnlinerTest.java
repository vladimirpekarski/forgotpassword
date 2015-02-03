import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.onliner.OnlinerInternalPage;
import pageobject.onliner.OnlinerLoginPage;
import pageobject.onliner.OnlinerMainPage;

import static helpers.UserCred.getUser;
import static helpers.Waiters.waitForElementDisplay;

public class LoginOnlinerTest extends BaseTest{
    private String onlinerUserName = getUser("onliner.user")[0];
    private String onlinerUserNewPass = getUser("onliner.user")[1];

    @Test
    public void loginTest(){
        OnlinerMainPage.clickEnterButton();
        OnlinerLoginPage.login(onlinerUserName, onlinerUserNewPass);
        waitForElementDisplay(OnlinerInternalPage.EXIT_LINK_LOCATOR);

        Assert.assertTrue(OnlinerInternalPage.isLoggedIn());
    }
}
