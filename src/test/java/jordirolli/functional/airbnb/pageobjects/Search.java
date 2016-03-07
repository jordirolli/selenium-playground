package jordirolli.functional.airbnb.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Search {

    private static DateTimeFormatter airBnbDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private WebElement location;
    @FindBy(id = "checkin")
    @CacheLookup
    private WebElement checkInDate;
    @FindBy(id = "checkout")
    @CacheLookup
    private WebElement checkOutDate;
    private WebElement guests;
    @FindBy(id = "submit_location")
    @CacheLookup
    private WebElement searchButton;


    public Search() {
        PageFactory.initElements(Browser.driver(), this);
    }

    public SearchResults search(String location, LocalDate checkInDate, LocalDate checkOutDate, Integer guests ) {
        this.location.sendKeys(location);
        this.checkInDate.sendKeys(checkInDate.format(airBnbDateFormat));
        this.checkOutDate.sendKeys(checkOutDate.format(airBnbDateFormat));
        Select guestsSelect = new Select(this.guests);
        guestsSelect.selectByIndex(guests-1);
        searchButton.click();
        return new SearchResults(location,checkInDate,checkOutDate,guests);
    } }