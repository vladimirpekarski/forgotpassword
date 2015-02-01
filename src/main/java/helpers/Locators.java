package helpers;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {
    public static final Properties LOCATORS;

    public static enum LocatorsType {
        id, name, css, xpath
    }

    static {
        LOCATORS = new Properties();
        InputStream in = Locators.class.getResourceAsStream("/locators.properties");

        try {
            LOCATORS.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static By getLocator(String locatorProperty) {
        String[] locatorTypeAndValue = LOCATORS.getProperty(locatorProperty)
                .split("=", 2);
        LocatorsType locatorsType = LocatorsType.valueOf(locatorTypeAndValue[0]);

        switch (locatorsType) {
            case id: {
                return By.id(locatorTypeAndValue[1]);
            }

            case name: {
                return By.name(locatorTypeAndValue[1]);
            }

            case css: {
                return By.cssSelector(locatorTypeAndValue[1]);
            }

            case xpath: {
                return By.xpath(locatorTypeAndValue[1]);
            }

            default: {
                throw  new IllegalArgumentException(
                        "Locator Type: " + locatorTypeAndValue[0] + "doesn't exist");
            }
        }
    }
}
