package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static helpers.Waiters.waitForTitle;
import static webdriversingleton.WebDriverSingleton.getWebdriver;

public class Actions {
    public static void takeScreenshot(String path) {
        TakesScreenshot screenshot = (TakesScreenshot)getWebdriver();
        File screen = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screen, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openURl(String url) {
        getWebdriver().get(url);
    }

    public static void switchTab(String title) {
        ArrayList<String> handles = new ArrayList<>(getWebdriver()
                .getWindowHandles());
        for (String handle: handles) {
            if(getWebdriver().switchTo().window(handle).getTitle().equals(title)) {
                break;
            }
        }
    }
}
