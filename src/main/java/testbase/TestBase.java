package testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import static webdriversingleton.WebDriverSingleton.quit;
import static webdriversingleton.WebDriverSingleton.initWebDriver;

public class TestBase {
    protected final static String BASE_URL = "http://www.onliner.by/";

    @BeforeMethod
    public void setup() throws MalformedURLException {
        initWebDriver(System.getProperty("browser", "firefox")).get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        quit();
    }
}
