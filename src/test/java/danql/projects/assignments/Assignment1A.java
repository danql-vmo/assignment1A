package danql.projects.assignments;

import com.github.martincooper.datatable.sorting.SortOrder;
import danql.utils.helpers.WebUI;
import danql.locators.Assignment1ALocator;
import danql.utils.logs.Log;
import io.vavr.control.Try;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.martincooper.datatable.*;


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
        List<String> codeList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<Double> changeList = new ArrayList<>();
        List<Integer> volumeList = new ArrayList<>();

        String code;
        String name;
        String change;
        String volume;

        Log.info("Top ten Stock by volume");
        Log.info("Code\t\tName\t\tChange\t\tVolume");
        for (int i = 0; i < 10; i++) {
            codeList.add(driver.findElements(stockCode).get(i).getText());
            nameList.add(driver.findElements(stockName).get(i).getText());
            change = driver.findElements(stockChange).get(i).getText();
            changeList.add(change.equals("-") ? 0.0f : Double.parseDouble(change));
            volumeList.add(Integer.parseInt(driver.findElements(stockVolume).get(i).getText().replaceAll(",", "")));
        }

        DataTable dt = DataTableBuilder
                .create("StockTable")
                .withColumn(String.class, "Code", codeList)
                .withColumn(String.class, "Name", nameList)
                .withColumn(Double.class, "Change", changeList)
                .withColumn(Integer.class, "Volume", volumeList)
                .build().get();
        dt.quickSort("Change", SortOrder.Descending);

        for (int i = 0; i < 10; i++) {
            code = dt.row(i).getAs(String.class, 0);
            name = dt.row(i).getAs(String.class, 1);
            for (int j = 0; j < 3 - name.length() / 3; j++) {
                name += "\t";
            }
            change = String.valueOf(dt.row(i).getAs(Double.class, 2));
            volume = String.valueOf(dt.row(i).getAs(Integer.class, 3));
            Log.info(code + "\t\t" + name + change + "\t\t" + volume);
        }
    }

}
