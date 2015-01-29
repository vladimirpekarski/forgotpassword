import basetest.BaseTest;
import helpers.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.onliner.OnlinerConfirmPage;

import static steps.Steps.goLostPageOnlinerAndSendEmail;

@Listeners(CustomListener.class)
public class OnlinerTest extends BaseTest {
    @Test
    public void confirmPageTest() throws InterruptedException {
        goLostPageOnlinerAndSendEmail("someemail");
        Assert.assertTrue(OnlinerConfirmPage.isConfirmPage());
    }
}
