package danql.projects.assignments;

import danql.locators.Assignment1ALocator;
import danql.utils.helpers.WebUI;
import danql.utils.logs.Log;
import danql.utils.helpers.StockData;
import danql.utils.helpers.WriteToFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;


public class Assignment1A {

    private WebDriver driver;
    private WebUI webUI;
    private static final HashMap<String, String> locator = Assignment1ALocator.getLocators();
    private By stockCode = By.xpath(locator.get("code"));
    private By stockName = By.xpath(locator.get("name"));
    private By stockChange = By.xpath(locator.get("change"));
    private By stockVolume = By.xpath(locator.get("volume"));
    WebElement[][] stockTable;

    public Assignment1A(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
    }


    public void getDailyTopTenByVolumeAndSortByChange() throws InterruptedException {
        List<StockData> stockList = new ArrayList<>();
        String code;
        String name;
        Double change;
        Integer volume;

        for (int i = 0; i < 10; i++) {
            code = driver.findElements(stockCode).get(i).getText();
            name = driver.findElements(stockName).get(i).getText();
            change = driver.findElements(stockChange).get(i).getText().equals("-") ? 0.0f : Double.parseDouble(driver.findElements(stockChange).get(i).getText());
            volume = Integer.parseInt(driver.findElements(stockVolume).get(i).getText().replaceAll(",", ""));
            stockList.add(new StockData(code, name, change, volume));
        }

        stockList.sort(Comparator.comparingDouble(StockData::getChange));
        Collections.reverse(stockList);
        for (StockData data : stockList) {
            System.out.println(data.toString());
            WriteToFile.writeToFile("/Users/quachlinhdan/stockData.txt", data.toString() + "\n", true);
        }
    }

}
