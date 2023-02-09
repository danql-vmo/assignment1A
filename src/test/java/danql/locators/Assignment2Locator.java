package danql.locators;

import java.util.HashMap;

public class Assignment2Locator extends BaseLocator {
    private static HashMap<String, String> locator = new HashMap<String, String>();

    public static HashMap<String, String> getLocators() {
        //Insert XPaths here
        locator.put("login button", "//a[@href='/auth/login']");
        locator.put("email","//input[@type='email']");
        locator.put("password","//input[@type='password']");
        locator.put("submit","//button[@type='submit']");
        return locator;
    }
}
