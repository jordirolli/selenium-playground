package jordirolli.functional.airbnb.pageobjects;

import jordirolli.functional.ApplicationProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class Browser {

    static {
        System.setProperty("webdriver.chrome.driver", ApplicationProperties.CHROME_DRIVER_PATH.getValue());
    }

    private static WebDriver driver = new ChromeDriver();

    public static WebDriver driver() {
        return driver;
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void close() {
        driver.close();
    }
}