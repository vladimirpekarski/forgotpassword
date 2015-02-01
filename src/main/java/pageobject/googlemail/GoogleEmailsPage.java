package pageobject.googlemail;
import static helpers.UserCred.getUser;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class GoogleEmailsPage {
    public static Boolean isGoogleEmailsPage() {
        return getWebdriver().getTitle().contains(getUser("google.user")[0]);
    }


}
