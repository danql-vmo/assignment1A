package danql.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseLocator {
    private static HashMap<String, String> locator = new HashMap<String, String>();
    public static HashMap<String, String> getLocators()
    {
        //Insert XPaths here
        locator.put("key", "value");
        return locator;
    }
}
