package jordirolli.functional.airbnb.pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.*;

public class HomePage extends LoadableComponent<HomePage> {
    static String url = "https://www.airbnb.co.nz";
    private static String title = "Vacation Rentals, Homes, Apartments & Accommodation - Airbnb New Zealand";

    public HomePage() {
        PageFactory.initElements(Browser.driver(), this);
    }

    @Override
    public void load() {
        Browser.open(url);
    }

    @Override
    public void isLoaded() {
        assertTrue(Browser.driver().getTitle().equals(title));
    }
    public void close() {
        Browser.close();
    }
    public Search Search() {
        Search search = new Search();
        return search;
    }
}

