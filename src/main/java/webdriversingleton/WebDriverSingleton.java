package webdriversingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver webDriver;
    private WebDriverSingleton() {};

    public static WebDriver getWebdriver() {
        if (webDriver != null) {
            return webDriver;
        }
        else {
            return new FirefoxDriver();
        }
    }

    public static WebDriver initWebDriver(String browser) {
        switch (browser) {
            case "chrome": {
                webDriver = new ChromeDriver();
                break;
            }
            case "firefox": {
                webDriver = new FirefoxDriver();
                break;
            }
            case "ie": {
                webDriver = new InternetExplorerDriver();
                break;
            }
            default: {
                webDriver = new FirefoxDriver();
            }
        }

        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        webDriver.manage().window().maximize();

        return webDriver;
    }
}
