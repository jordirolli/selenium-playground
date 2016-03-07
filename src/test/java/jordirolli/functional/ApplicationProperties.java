package jordirolli.functional;

/**
 * Created by jordirolli on 5/3/16.
 */
public enum ApplicationProperties {
    CHROME_DRIVER_PATH("/Users/jordirolli/Documents/development/node_modules/chromedriver/bin/chromedriver");

    String value;

    ApplicationProperties(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
