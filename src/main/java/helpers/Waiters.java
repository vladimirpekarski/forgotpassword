package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class Waiters {
    public static void waitUntilScriptsEnd() {
        (new WebDriverWait(getWebdriver(), 15)).until(new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return js.executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public static void waitForSpecificTilte(final String title) {
        (new WebDriverWait(getWebdriver(), 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return ((d.getTitle().contains(title)));
            }
        });
    }
}
