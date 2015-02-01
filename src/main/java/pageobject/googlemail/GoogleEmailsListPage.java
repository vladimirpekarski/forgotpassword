package pageobject.googlemail;
import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static helpers.UserCred.getUser;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class GoogleEmailsListPage {
    public static final By ONLINER_LINK_LABEL = getLocator("googleEmailsListPage.onlinerLink");

    public static Boolean isGoogleEmailsListPage() {
        return getWebdriver().getTitle().contains(getUser("google.user")[0]);
    }

    public static void openOnlinerEmail() {
        getWebdriver().findElement(ONLINER_LINK_LABEL).click();
    }
}
