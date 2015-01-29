import basetest.BaseTest;
import helpers.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.onliner.OnlinerConfitmPage;

import static steps.Steps.goLostPageOnlinerAndSendEmail;

@Listeners(CustomListener.class)
public class OnlinetTest extends BaseTest {
    @Test
    public void confirmPageTest() throws InterruptedException {
        goLostPageOnlinerAndSendEmail("someemail");
        Assert.assertTrue(OnlinerConfitmPage.isConfirmPage());
    }
}
