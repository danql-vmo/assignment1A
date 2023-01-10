package danql.projects.assignments;

import danql.utils.helpers.WebUI;
import danql.locators.Assignment1ALocator;
import danql.utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class Assignment1A {

    private WebDriver driver;
    private WebUI webUI;
    private static final HashMap<String, String> locator = Assignment1ALocator.getLocators();

    public Assignment1A(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    private By stockCode = By.xpath(locator.get("code"));
    private By stockName = By.xpath(locator.get("name"));
    private By stockChange = By.xpath(locator.get("change"));
    private By stockVolume = By.xpath(locator.get("volume"));

    public void getDailyTopTenByVolume() throws InterruptedException {
        Log.info("Top ten Stock by volume");
        Log.info("Code\t\tName\t\t\tChange\t\tVolume");
        List<WebElement> stockCodeList = driver.findElements(stockCode);
        List<WebElement> stockNameList = driver.findElements(stockName);
        List<WebElement> stockChangeList = driver.findElements(stockChange);
        List<WebElement> stockVolumeList = driver.findElements(stockVolume);
        for (int i = 0; i < 10; i++) {
            String code = stockCodeList.get(i).getText();
            String name = stockNameList.get(i).getText();
            String change = stockChangeList.get(i).getText();
            if (change.equals("-")) change = "0";
            String volume = stockVolumeList.get(i).getText();

            Log.info(code + "\t\t" + name + "\t\t\t" + change + "\t\t" + volume);
        }
    }

}
