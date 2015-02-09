package steps;

import pageobject.onliner.OnlinerLoginPage;
import pageobject.onliner.OnlinerLostPage;
import pageobject.onliner.OnlinerMainPage;

public class Steps {
    public static void goLostPageOnliner() { //should be renamed
        OnlinerMainPage.clickEnterButton();
        OnlinerLoginPage.clickForgotLink();
    }

    public static void goLostPageOnlinerAndSendEmail(String userEmail) { //should be renamed
        goLostPageOnliner();
        OnlinerLostPage.typeEmailAndSend(userEmail);
    }
}
