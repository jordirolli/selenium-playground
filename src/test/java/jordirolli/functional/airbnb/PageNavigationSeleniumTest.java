package jordirolli.functional.airbnb;


import org.junit.Test;
import static org.junit.Assert.*;

import jordirolli.functional.airbnb.pageobjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class PageNavigationSeleniumTest {

    @Test
    public void testProductSearch()
    {
        //Create an instance of Home page
        HomePage homePage = new HomePage();
        //Navigate to the Home page
        homePage.get();


        SearchResults searchResult = homePage.Search().search("Wellington",
                LocalDate.of(2016,04,04),
                LocalDate.of(2016,04,10),
                2);
        //Verify there are 2 products available with this search
        assertEquals(18, searchResult.getSearchResults().size());
        Browser.close();
    }

}
