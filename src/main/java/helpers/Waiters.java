package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class Waiters {
    public static void waitUntilPageLoaging() {
        (new WebDriverWait(getWebdriver(), 10)).until(new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return js.executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public static void waitForTitle(final String title) {  // todo: should be equal instead of contains
        //Q: renamed method from waitForSpecificTitle to waitForTitle as google
        // contains titles like 'Inbox (N) - userName - Gmail' - hard to check this title (N could be any number)
        // Is it Ok?
        (new WebDriverWait(getWebdriver(), 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return ((d.getTitle().contains(title)));
            }
        });
    }

    public static void waitForElementDisplay(final By locator) {
        (new WebDriverWait(getWebdriver(), 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElement(locator).isDisplayed();
            }
        });
    }
}
