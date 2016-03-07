package jordirolli.functional.airbnb.pageobjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.Assert.assertTrue;

public class SearchResults extends LoadableComponent<SearchResults> {


    private String location;
    private LocalDate checkin;
    private LocalDate checkout;
    private Integer guests;

    public SearchResults(String location, LocalDate startDate, LocalDate endDate, Integer guests) {
        PageFactory.initElements(Browser.driver(), this);
    }

    @Override
    public void isLoaded() {
        assertTrue(Browser.driver().getTitle().equals(this.location + " Holiday Rentals & Accommodation - Airbnb"));
    }

    @Override
    protected void load() {
        // TODO Auto-generated method stub
    }


    public List<SearchResult> getSearchResults() {
        List<SearchResult> availableHosts = new ArrayList<SearchResult>();
        List<WebElement> hostList = Browser.driver().findElements(By.xpath("//div[@itemtype='http://schema.org/Enumeration']"));
        for (WebElement item : hostList)
            availableHosts.add(SearchResult.getSearchResult(item));
        return availableHosts;
    }

    public void close() {
        Browser.close();
    }

    /* I comment this as the search DOM is not the same for the home page and the results page
    public Search Search() {
        Search search = new Search();
        return search;
    }
    */
}

