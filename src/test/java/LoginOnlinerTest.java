import basetest.BaseTest;
import org.testng.annotations.Test;
import pageobject.onliner.OnlinerLoginPage;
import pageobject.onliner.OnlinerMainPage;

import static helpers.UserCred.getUser;

public class LoginOnlinerTest extends BaseTest{
    @Test
    public void loginTest(){
        OnlinerMainPage.clickEnterButton();
        OnlinerLoginPage.login(getUser("onliner.user")[0], getUser("onliner.user")[1]);
    }
}
