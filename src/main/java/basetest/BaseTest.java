package basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static webdriversingleton.WebDriverSingleton.getWebdriver;
import static webdriversingleton.WebDriverSingleton.initWebDriver;

public class BaseTest {
    protected static String BASE_URL = "http://www.onliner.by/";
    protected static String browser;

    @BeforeMethod
    public void setUpDriver() {
        browser = System.getProperty("browser", "firefox");
        initWebDriver(browser).get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        getWebdriver().quit();
    }
}
