package jordirolli.functional.airbnb.pageobjects;

// TODO make private attributes with public accesors

import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParsePosition;

/**
 * Represents the following element on the airBnB search results:
 * <div data-lat="-41.29433166899946" data-lng="174.77006338181903" data-name="Heritage &amp; Central"
 *  data-url="/rooms/11244702?checkin=15-03-2016&amp;checkout=22-03-2016&amp;s=Sc4Qqw8Y"
 *  data-user="15171096" data-id="11244702" data-instant-book="false" data-price="<sup>€</sup>43<sup></sup>"
 *  data-has-superhost-badge="false" data-has-new-listing-badge="false" data-star-rating="5.0" data-review-count="3"
 *  class="listing" itemscope="" itemtype="http://schema.org/Enumeration">
 * ...
 * </div>
 * */
public class SearchResult{

    private String name;
    private String url;
    private Integer id;
    private Integer userId;
    // TODO use the JSR 354
    private BigDecimal price;
    private BigDecimal latittude;
    private BigDecimal longitude;

    public static SearchResult getSearchResult(WebElement container){
        SearchResult newSearchResult = new SearchResult();
        newSearchResult.name = container.getAttribute("data-name");
        newSearchResult.url = container.getAttribute("data-url");
        newSearchResult.id = Integer.valueOf(container.getAttribute("data-id"));
        newSearchResult.userId = Integer.valueOf(container.getAttribute("data-user"));
        // newSearchResult.price = container.getAttribute("data-price");
        newSearchResult.latittude = new BigDecimal(container.getAttribute("data-lat"));
        newSearchResult.longitude = new BigDecimal(container.getAttribute("data-lng"));
        return newSearchResult;
    }

}

