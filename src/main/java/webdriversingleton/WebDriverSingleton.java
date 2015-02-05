package webdriversingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static Map<Long, WebDriver> driverBus = new ConcurrentHashMap<>();
    private WebDriverSingleton() {};

    public static WebDriver getWebdriver() {
        if (driverBus.containsKey(Thread.currentThread().getId())) {
            return driverBus.get(Thread.currentThread().getId());
        }
        else {
            return new FirefoxDriver();
        }
    }

    public static WebDriver initWebDriver(String browser) {
        WebDriver webDriver;

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

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driverBus.put(Thread.currentThread().getId(), webDriver);

        return webDriver;
    }

    public static void quit() {
        if(driverBus.containsKey(Thread.currentThread().getId())) {
            WebDriver driver = driverBus.get(Thread.currentThread().getId());
            if(driver != null) {
                driver.quit();
            }

            driverBus.remove(Thread.currentThread().getId());
        }
    }
}
