package jordirolli.functional;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(JUnit4.class)
public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", ApplicationProperties.CHROME_DRIVER_PATH.getValue());
        driver = new ChromeDriver();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("webdriver");
        searchBox.submit();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the pageobjects to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Object>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("webdriver");
            }
        });

        assertEquals("webdriver - Buscar con Google", driver.getTitle());
    }
}