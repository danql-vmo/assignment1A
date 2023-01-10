package danql.locators;

import java.util.HashMap;

public class Assignment1ALocator {
    private static HashMap<String, String> locator = new HashMap<String, String>();

    public static HashMap<String, String> getLocators() {
        //Insert XPaths here
        locator.put("code", "//div[contains(@class,'active')]/table/tbody/tr/td[1]");
        locator.put("name", "//div[contains(@class,'active')]/table/tbody/tr/th/div/a");
        locator.put("change", "//div[contains(@class,'active')]/table/tbody/tr/td[3]");
        locator.put("volume", "//div[contains(@class,'active')]/table/tbody/tr/td[4]");
        return locator;
    }
}
