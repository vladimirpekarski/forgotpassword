package pageobject.googlemail;
import org.openqa.selenium.By;

import static helpers.Locators.getLocator;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class GoogleEmailsListPage {
    public static final By ONLINER_LINK_LABEL = getLocator("googleEmailsListPage.onlinerLink");

    public static Boolean isUserLoggedIn(String userName) {
        return getWebdriver().getTitle().contains(userName);
    }

    public static void openOnlinerEmail() {
        getWebdriver().findElement(ONLINER_LINK_LABEL).click();
    }
}
