package steps;

import pageobject.onliner.OnlinerLoginPage;
import pageobject.onliner.OnlinerLostPage;
import pageobject.onliner.OnlinerMainPage;

public class Steps {
    public static void openLostPageOnliner() {
        OnlinerMainPage.clickEnterButton();
        OnlinerLoginPage.clickForgotLink();
    }

    public static void openLostPageOnlinerAndSendEmail(String userEmail) {
        openLostPageOnliner();
        OnlinerLostPage.typeEmailAndSend(userEmail);
    }
}
