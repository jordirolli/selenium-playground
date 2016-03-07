package jordirolli.functional.bmicalc.pageobjects;

import jordirolli.functional.ApplicationProperties;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

// TODO Seguir per pag 170 de llibre


/**
 * Created by jordirolli on 5/3/16.
 */
public class BmiCalcPage extends LoadableComponent<BmiCalcPage> {


    /* This does not be to be done if the name of the fied does match the 'name' or 'id' html attributes. */
    @FindBy(id = "heightCMS")
    @CacheLookup
    public WebElement heightField;

    public WebElement weightKg;
    public WebElement Calculate;
    public WebElement bmi;
    public WebElement bmi_category;
    private WebDriver driver;
    private String url = "http://dl.dropbox.com/u/55228056/bmicalculator.html";
    private String title = "BMI Calculator";

    public BmiCalcPage() {
        System.setProperty("webdriver.chrome.driver", ApplicationProperties.CHROME_DRIVER_PATH.getValue());
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    public void load() {
        this.driver.get(url);
    }

    public void close() {
        this.driver.close();
    }

    @Override
    protected void isLoaded() {
        assertTrue(driver.getTitle().equals(title));
    }

    public void calculateBmi(String height, String weight) {
        heightField.sendKeys(height);
        weightKg.sendKeys(weight);
        Calculate.click();
    }

    public String getBmi() {
        return bmi.getAttribute("value");
    }

    public String getBmiCategory() {
        return bmi_category.getAttribute("value");
    }



}
