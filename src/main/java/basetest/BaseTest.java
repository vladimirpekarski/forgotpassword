package basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static webdriversingleton.WebDriverSingleton.quit;
import static webdriversingleton.WebDriverSingleton.initWebDriver;

public class BaseTest { // todo: what is better BaseTest or TestBase?
    // A: I think it's better to use BaseTest, because it means basic parent class and
    // all other test classes extend it
    protected final static String BASE_URL = "http://www.onliner.by/";

    @BeforeMethod
    public void setup() {
        initWebDriver(System.getProperty("browser", "chrome")).get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        quit();
    }
}
