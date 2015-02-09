package basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import static webdriversingleton.WebDriverSingleton.quit;
import static webdriversingleton.WebDriverSingleton.initWebDriver;

public class BaseTest { // todo: what is better BaseTest or TestBase?
    // A: I think it's better to use BaseTest, because it means basic parent class and
    // all other test classes extend it
    // Говоря о филологии, с английского baseTest значит базовый тест (по сути он тестовым классом не является), а TestBase - база для теста. Но на самом деле
    // используют и тот, и другой вариант, как больше нравится. Главное тогда не мешать стили - PageBase, ElementBase...
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
