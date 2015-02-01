package pageobject.googlemail;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class GoogleEmailsPage {
    public static Boolean isGoogleEmailsPage() {
        return getWebdriver().getTitle().contains("email");
    }
}
